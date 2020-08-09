package com.pkkor.pandemic.actions.impl.basic;

import com.pkkor.pandemic.actions.AbstractMoveAction;
import com.pkkor.pandemic.entities.player.AbstractPlayer;

public class BasicMoveAction extends AbstractMoveAction {

    @Override
    protected boolean specialMoveValid(AbstractPlayer player, AbstractPlayer playerToMove, String location) {
        return false;
    }

    @Override
    protected void specialMove(AbstractPlayer player, AbstractPlayer playerToMove, String location) {

    }
}
