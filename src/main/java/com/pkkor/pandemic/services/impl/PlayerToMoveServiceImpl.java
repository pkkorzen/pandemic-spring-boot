package com.pkkor.pandemic.services.impl;

import com.pkkor.pandemic.entities.player.AbstractPlayer;
import com.pkkor.pandemic.services.PlayerToMoveService;
import org.springframework.stereotype.Service;

@Service
public class PlayerToMoveServiceImpl implements PlayerToMoveService {
    private AbstractPlayer player;

    public PlayerToMoveServiceImpl() {
        player = null;
    }

    @Override
    public AbstractPlayer getPlayer() {
        AbstractPlayer playerToMove = player;
        player = null;
        return playerToMove;
    }

    @Override
    public void setPlayer(AbstractPlayer player) {
        this.player = player;
    }
}
