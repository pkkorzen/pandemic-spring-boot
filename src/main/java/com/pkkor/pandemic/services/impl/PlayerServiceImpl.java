package com.pkkor.pandemic.services.impl;

import com.pkkor.pandemic.services.PlayerService;
import com.pkkor.pandemic.entities.player.AbstractPlayer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static List<AbstractPlayer> players;

    static {
        players = new ArrayList<>();
    }

    @Override
    public AbstractPlayer findById(int Id) {
        return players.get(Id);
    }

    @Override
    public List<AbstractPlayer> findAllPlayers() {
        return players;
    }

    @Override
    public void savePlayer(AbstractPlayer player) {
        players.add(player);
        players.add(player.getId() - 1, player);
        players.remove(player.getId());
    }

    @Override
    public void clearPlayers() {
        players.clear();
    }
}
