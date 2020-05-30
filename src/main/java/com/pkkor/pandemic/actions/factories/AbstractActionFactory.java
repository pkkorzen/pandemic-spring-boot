package com.pkkor.pandemic.actions.factories;

import com.pkkor.pandemic.actions.Action;
import com.pkkor.pandemic.enums.characters.Characters;

public abstract class AbstractActionFactory {
    abstract Action getAction(Enum<Characters> charactersEnum);
}
