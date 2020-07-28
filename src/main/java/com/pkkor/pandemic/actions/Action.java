package com.pkkor.pandemic.actions;

import com.pkkor.pandemic.entities.player.AbstractPlayer;

public interface Action {
    void execute(AbstractPlayer player, String... args);
}
