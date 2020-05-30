package com.pkkor.pandemic.actions.factories;

import com.pkkor.pandemic.actions.Action;
import com.pkkor.pandemic.actions.impl.basic.BasicBuildAction;
import com.pkkor.pandemic.actions.impl.operations_expert.OperationsExpertABuildAction;
import com.pkkor.pandemic.enums.characters.Characters;

public class BuildActionFactory extends AbstractActionFactory {
    @Override
    Action getAction(Enum<Characters> charactersEnum) {
        if (charactersEnum.equals(Characters.OPERATIONS_EXPERT)) {
            return new OperationsExpertABuildAction();
        } else {
            return new BasicBuildAction();
        }
    }
}
