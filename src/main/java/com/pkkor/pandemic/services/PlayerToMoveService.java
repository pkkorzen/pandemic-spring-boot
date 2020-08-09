package com.pkkor.pandemic.services;

import com.pkkor.pandemic.entities.player.AbstractPlayer;

public interface PlayerToMoveService {
    AbstractPlayer getPlayer();
    void setPlayer(AbstractPlayer player);
}
