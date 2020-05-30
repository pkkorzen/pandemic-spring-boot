package com.pkkor.pandemic.actions.factories;

import com.pkkor.pandemic.actions.Action;
import com.pkkor.pandemic.actions.impl.basic.BasicMoveAction;
import com.pkkor.pandemic.actions.impl.dispatcher.DispatcherAMoveAction;
import com.pkkor.pandemic.enums.characters.Characters;

public class MoveActionFactory extends AbstractActionFactory {
    @Override
    Action getAction(Enum<Characters> charactersEnum) {
        if (charactersEnum.equals(Characters.DISPATCHER)) {
            return new DispatcherAMoveAction();
        } else {
            return new BasicMoveAction();
        }
    }
}
