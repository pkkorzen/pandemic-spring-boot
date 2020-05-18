package com.pkkor.pandemic.services.impl;

import com.pkkor.pandemic.entities.player.Player;
import com.pkkor.pandemic.services.PlayerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static List<Player> players;

    static {
        players = new ArrayList<>();
    }

    @Override
    public Player findById(int Id) {
        return players.get(Id);
    }

    @Override
    public List<Player> findAllPlayers() {
        return players;
    }

    @Override
    public void savePlayer(Player player) {
        players.add(player);
    }

    @Override
    public void clearPlayers() {
        players.clear();
    }
}
