package com.pkkor.pandemic.actions;

import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.mappers.CardMapper;
import com.pkkor.pandemic.services.*;
import com.pkkor.pandemic.utils.SpringApplicationContext;
import com.pkkor.pandemic.entities.player.AbstractPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractMoveAction implements Action {

    CardMapper cardMapper = (CardMapper) SpringApplicationContext.getBean("cardMapper");

    @Override
    public final void execute(AbstractPlayer player, String... args) {

        PlayerToMoveService playerToMoveService = (PlayerToMoveService) SpringApplicationContext.getBean("playerToMoveServiceImpl");
        MoveChoiceService moveChoiceService = (MoveChoiceService) SpringApplicationContext.getBean("moveChoiceServiceImpl");
        AbstractPlayer playerToMove;

        if (playerToMoveService.getPlayer() != null) {
            playerToMove = playerToMoveService.getPlayer();
        } else {
            playerToMove = player;
        }

        if (driveFerryMoveValid(playerToMove, args[0]) || shuttleFlightValid(playerToMove, args[0])) {
            playerToMove.setCity(args[0]);
        /*} else if (specialMoveValid()) {
            specialMove();*/
            //TODO: still need to figure out how to decide on correct move, when two out of those three are true
            //TODO: another ifs are required to be sure, which two out of three moves are valid and decide
            // which one to choose
            /*} else if (specialMoveValid() && directFlightValid() && charterFlightValid()) {*/

        } else if (specialMoveValid(player, playerToMove, args[0])) {
            if (directFlightValid(player, args[0])) {
                if (charterFlightValid(player, playerToMove)) {
                    //special,direct and charter logic
                    moveChoiceService.addChoice("Special"); //maybe enum instead of strings
                    moveChoiceService.addChoice("Direct");
                    moveChoiceService.addChoice("Charter");
                    startThread(player, moveChoiceService, playerToMove, args[0]);

                } else {
                    //special and direct logic
                    moveChoiceService.addChoice("Special"); //maybe enum instead of strings
                    moveChoiceService.addChoice("Direct");
                    startThread(player, moveChoiceService, playerToMove, args[0]);
                }
            } else if (charterFlightValid(player, playerToMove)) {
                //special and charter logic
                moveChoiceService.addChoice("Special"); //maybe enum instead of strings
                moveChoiceService.addChoice("Charter");
                startThread(player, moveChoiceService, playerToMove, args[0]);
            } else {
                specialMove(player, playerToMove, args[0]);
            }

        } else if (directFlightValid(player, args[0]) && charterFlightValid(player, playerToMove)) {
            //direct and charter logic
            moveChoiceService.addChoice("Direct"); //maybe enum instead of strings
            moveChoiceService.addChoice("Charter");
            startThread(player, moveChoiceService, playerToMove, args[0]);
        } else if (directFlightValid(player, args[0])) {
            executeFlight(player, playerToMove, args[0]);
        } else if (charterFlightValid(player, playerToMove)) {
            executeFlight(player, playerToMove, playerToMove.getCity());
        }
    }

    final boolean driveFerryMoveValid(AbstractPlayer player, String location) {
        ConnectionsService connectionsService = (ConnectionsService) SpringApplicationContext.getBean("connectionServiceImpl");
        Map<String, List<String>> connections = connectionsService.getConnections();
        List<String> activePlayerLocationConnections = connections.get(player.getCity());
        boolean validMove;
        if (activePlayerLocationConnections == null) {
            activePlayerLocationConnections = connections.get(location);
            validMove = isValidMove(activePlayerLocationConnections, player.getCity());
        } else {
            validMove = isValidMove(activePlayerLocationConnections, location);
        }
        return validMove;
    }

    final boolean shuttleFlightValid(AbstractPlayer player, String location) {
        ResearchStationService researchStationService =
                (ResearchStationService) SpringApplicationContext.getBean("researchStationServiceImpl");
        return researchStationService.contains(player.getCity()) && researchStationService.contains(location);
    }

    protected abstract boolean specialMoveValid(AbstractPlayer player, AbstractPlayer playerToMove, String location);

    protected abstract void specialMove(AbstractPlayer player, AbstractPlayer playerToMove, String location);

    final boolean directFlightValid(AbstractPlayer player, String location) {
        return isValidFlight(player, location);
    }

    final boolean charterFlightValid(AbstractPlayer player, AbstractPlayer playerToMove) {
        return isValidFlight(player, playerToMove.getCity());
    }

    private boolean isValidMove(List<String> activePlayerLocationConnections, String location) {
        for (String activePlayerLocationConnection : activePlayerLocationConnections) {
            if (activePlayerLocationConnection.equals(location)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidFlight(AbstractPlayer player, String location) {
        Card[] playerCards = player.getCards();
        List<Card> matchingCards = Arrays.stream(playerCards)
                .filter(card -> cardMapper.convertToNameString(card).equals(location))
                .collect(Collectors.toList());
        return !matchingCards.isEmpty();
    }

    private void startThread(AbstractPlayer player, MoveChoiceService moveChoiceService, AbstractPlayer playerToMove, String location) {
        Thread thread = new Thread(() -> {
            synchronized (moveChoiceService.getChoices()) {
                while (moveChoiceService.getChoices().size() > 1) {
                    try {
                        moveChoiceService.getChoices().wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                String optionChosen = moveChoiceService.getChoices().get(0);
                moveChoiceService.clear();
                callMoveMethod(optionChosen, player, playerToMove, location);
            }
        });
        thread.start();
    }

    private void callMoveMethod(String optionChosen, AbstractPlayer player, AbstractPlayer playerToMove, String location) {
        switch (optionChosen) {
            case "Special":
                specialMove(player, playerToMove, location);
            case "Direct":
                executeFlight(player, playerToMove, location);
            case "Charter":
                executeFlight(player, playerToMove, playerToMove.getCity());
        }

    }

    private void executeFlight(AbstractPlayer player, AbstractPlayer playerToMove, String location) {
        PlayerDiscardPileService playerDiscardPileService = (PlayerDiscardPileService) SpringApplicationContext.getBean("playerDiscardPileServiceImpl");
        Card[] playerCards = player.getCards();
        for (int i = 0; i < playerCards.length; i++) {
            if (cardMapper.convertToNameString(playerCards[i]).equals(location)) {
                playerToMove.setCity(location);
                playerDiscardPileService.addToDiscardPile(playerCards[i]);
                playerCards[i] = null;
                break;
            }
        }
    }
}
