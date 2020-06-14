package com.pkkor.pandemic.simple_factory.players.impl;

import com.pkkor.pandemic.actions.impl.basic.*;
import com.pkkor.pandemic.actions.impl.scientist.ScientistACureAction;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;
import com.pkkor.pandemic.simple_factory.players.AbstractPlayer;

public class ScientistPlayer extends AbstractPlayer {

    public ScientistPlayer() {
        character = Characters.SCIENTIST;
        city = "Atlanta";
        actionsNumber = 4;
        cards = new Card[6];
        moveAction = new BasicMoveAction();
        buildAction = new BasicBuildAction();
        treatAction = new BasicTreatAction();
        knowledgeSharingAction = new BasicShareAction();
        cureAction = new ScientistACureAction();
    }

    public ScientistPlayer(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }
}
