package com.pkkor.pandemic.actions.impl.dispatcher;

import com.pkkor.pandemic.actions.AbstractMoveAction;
import com.pkkor.pandemic.entities.player.AbstractPlayer;
import com.pkkor.pandemic.services.PlayerService;
import com.pkkor.pandemic.utils.SpringApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

public class DispatcherMoveAction extends AbstractMoveAction {
    @Override
    protected boolean specialMoveValid(AbstractPlayer player, AbstractPlayer playerToMove, String location) {
        PlayerService playerService = (PlayerService) SpringApplicationContext.getBean("playerServiceImpl");
        List<AbstractPlayer> players = playerService.findByCity(location)
                .stream()
                .filter(x -> !x.equals(playerToMove))
                .collect(Collectors.toList());
        return !players.isEmpty();
    }

    @Override
    protected void specialMove(AbstractPlayer player, AbstractPlayer playerToMove, String location) {

    }
}
