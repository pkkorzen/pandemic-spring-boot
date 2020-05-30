package com.pkkor.pandemic.actions.factories;

import com.pkkor.pandemic.actions.Action;
import com.pkkor.pandemic.actions.impl.basic.BasicTreatAction;
import com.pkkor.pandemic.actions.impl.medic.MedicATreatAction;
import com.pkkor.pandemic.enums.characters.Characters;

public class TreatActionFactory extends AbstractActionFactory {
    @Override
    Action getAction(Enum<Characters> charactersEnum) {
        if (charactersEnum.equals(Characters.MEDIC)) {
            return new MedicATreatAction();
        } else {
            return new BasicTreatAction();
        }
    }
}
