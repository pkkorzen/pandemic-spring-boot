package com.pkkor.pandemic.services;

import com.pkkor.pandemic.entities.player.AbstractPlayer;

import java.util.Queue;

public interface PlayerOrderService {
    AbstractPlayer getActivePlayer();
    Queue<AbstractPlayer> getQueue();
    void insertIntoQueue(AbstractPlayer player);
    AbstractPlayer getAndRemove();
}
