package com.pkkor.pandemic.services.impl;

import com.pkkor.pandemic.entities.player.AbstractPlayer;
import com.pkkor.pandemic.services.PlayerOrderService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class PlayerOrderServiceImpl implements PlayerOrderService {

    private static Queue<AbstractPlayer> playerOrder;

    static {
        playerOrder = new LinkedList<>();
    }

    @Override
    public AbstractPlayer getActivePlayer() {
        return playerOrder.peek();
    }

    @Override
    public Queue<AbstractPlayer> getQueue() {
        return playerOrder;
    }

    @Override
    public void insertIntoQueue(AbstractPlayer player) {
        playerOrder.offer(player);
    }

    @Override
    public AbstractPlayer getAndRemove() {
        return playerOrder.remove();
    }
}
