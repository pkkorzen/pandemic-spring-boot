package com.pkkor.pandemic.actions.factories;

import com.pkkor.pandemic.actions.Action;
import com.pkkor.pandemic.actions.impl.basic.BasicCureAction;
import com.pkkor.pandemic.actions.impl.scientist.ScientistACureAction;
import com.pkkor.pandemic.enums.characters.Characters;

public class CureActionFactory extends AbstractActionFactory {
    @Override
    Action getAction(Enum<Characters> charactersEnum) {
        if (charactersEnum.equals(Characters.SCIENTIST)) {
            return new ScientistACureAction();
        } else {
            return new BasicCureAction();
        }
    }
}
