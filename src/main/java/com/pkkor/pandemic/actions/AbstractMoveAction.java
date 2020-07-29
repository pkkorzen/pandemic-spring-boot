package com.pkkor.pandemic.actions;

import com.pkkor.pandemic.services.ResearchStationService;
import com.pkkor.pandemic.utils.SpringApplicationContext;
import com.pkkor.pandemic.entities.player.AbstractPlayer;
import com.pkkor.pandemic.services.ConnectionsService;

import java.util.List;
import java.util.Map;

public abstract class AbstractMoveAction implements Action {
    @Override
    public final void execute(AbstractPlayer player, String... args) {

        if (driveFerryMoveValid(player, args[0]) || shuttleFlightValid(player, args[0])) {
            player.setCity(args[0]);
        /*} else if (specialMoveValid()) {
            specialMove();*/
            //TODO: still need to figure out how to decide on correct move, when two out of those three are true
            //TODO: another ifs are required to be sure, which two out of three moves are valid and decide
            // which one to choose
            /*} else if (specialMoveValid() && directFlightValid() && charterFlightValid()) {*/

        } else if (specialMoveValid()) {
            if (directFlightValid()) {
                if (charterFlightValid()) {
                    //special, direct and charter logic
                } else {
                    //special and direct logic
                }
            } else if (charterFlightValid()) {
                //special and charter logic
            } else {
                specialMove();
            }

        } else if (directFlightValid() && charterFlightValid()) {

        } else if (directFlightValid()) {

        } else if (charterFlightValid()) {

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

    protected abstract boolean specialMoveValid();

    protected abstract void specialMove();

    final boolean directFlightValid() {
        return false;
    }

    final boolean charterFlightValid() {
        return false;
    }

    private boolean isValidMove(List<String> activePlayerLocationConnections, String location) {
        for (String activePlayerLocationConnection : activePlayerLocationConnections) {
            if (activePlayerLocationConnection.equals(location)) {
                return true;
            }
        }
        return false;
    }

}
