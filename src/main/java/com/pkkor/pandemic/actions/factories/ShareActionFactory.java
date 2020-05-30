package com.pkkor.pandemic.actions.factories;

import com.pkkor.pandemic.actions.Action;
import com.pkkor.pandemic.actions.impl.basic.BasicShareAction;
import com.pkkor.pandemic.actions.impl.researcher.ResearcherAShareAction;
import com.pkkor.pandemic.enums.characters.Characters;

public class ShareActionFactory extends AbstractActionFactory {
    @Override
    Action getAction(Enum<Characters> charactersEnum) {
        if (charactersEnum.equals(Characters.RESEARCHER)) {
            return new ResearcherAShareAction();
        } else {
            return new BasicShareAction();
        }
    }
}
