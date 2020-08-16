package com.pkkor.pandemic.actions.impl.operations_expert;

import com.pkkor.pandemic.actions.AbstractMoveAction;
import com.pkkor.pandemic.entities.player.AbstractPlayer;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.services.CardChoiceService;
import com.pkkor.pandemic.services.PlayerDiscardPileService;
import com.pkkor.pandemic.services.ResearchStationService;
import com.pkkor.pandemic.utils.SpringApplicationContext;

public class OperationsExpertMoveAction extends AbstractMoveAction {

    @Override
    protected boolean specialMoveValid(AbstractPlayer player, AbstractPlayer playerToMove, String location) {
        ResearchStationService researchStationService = (ResearchStationService) SpringApplicationContext.getBean("researchStationServiceImpl");
        return researchStationService.contains(player.getCity());
    }

    @Override
    protected void specialMove(AbstractPlayer player, AbstractPlayer playerToMove, String location) {
        CardChoiceService cardChoiceService = (CardChoiceService) SpringApplicationContext.getBean("cardChoiceServiceImpl");

        Thread thread = new Thread(() -> {
            synchronized (cardChoiceService.getCards()) {
                while (cardChoiceService.getCards().size() == 0) {
                    try {
                        cardChoiceService.getCards().wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                PlayerDiscardPileService playerDiscardPileService = (PlayerDiscardPileService) SpringApplicationContext.getBean("playerDiscardPileServiceImpl");
                Card[] playerCards = playerToMove.getCards();
                for (int i = 0; i < playerCards.length; i++) {
                    if (playerCards[i].equals(cardChoiceService.getCards().get(0))) {
                        playerToMove.setCity(location);
                        playerDiscardPileService.addToDiscardPile(playerCards[i]);
                        playerCards[i] = null;
                        cardChoiceService.getCards().clear();
                        break;
                    }
                }
            }
        });
        thread.start();

    }
}
