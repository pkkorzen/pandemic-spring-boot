package com.pkkor.pandemic.actions.impl.dispatcher;

import com.pkkor.pandemic.actions.AbstractMoveAction;

public class DispatcherAMoveAction extends AbstractMoveAction {
    @Override
    protected boolean specialMoveValid() {
        return false;
    }

    @Override
    protected void specialMove() {

    }
}
