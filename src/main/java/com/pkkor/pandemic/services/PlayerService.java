package com.pkkor.pandemic.services;

import com.pkkor.pandemic.entities.player.AbstractPlayer;

import java.util.List;

public interface PlayerService {
    AbstractPlayer findById(int Id);
    List<AbstractPlayer> findAllPlayers();
    void savePlayer(AbstractPlayer player);
    void clearPlayers();
}
