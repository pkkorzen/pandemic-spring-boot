package com.pkkor.pandemic.services;

import com.pkkor.pandemic.entities.player.Player;

import java.util.List;

public interface PlayerService {
    Player findById(int Id);
    List<Player> findAllPlayers();
    void savePlayer(Player player);
}
