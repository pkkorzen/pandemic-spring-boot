package com.pkkor.pandemic.simple_factory.players.impl;

import com.pkkor.pandemic.actions.impl.basic.*;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;
import com.pkkor.pandemic.simple_factory.players.AbstractPlayer;

public class QuarantineSpecialistPlayer extends AbstractPlayer {

    public QuarantineSpecialistPlayer() {
        character = Characters.QUARANTINE_SPECIALIST;
        city = "Atlanta";
        actionsNumber = 4;
        cards = new Card[6];
        moveAction = new BasicMoveAction();
        buildAction = new BasicBuildAction();
        treatAction = new BasicTreatAction();
        knowledgeSharingAction = new BasicShareAction();
        cureAction = new BasicCureAction();
    }

    public QuarantineSpecialistPlayer(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }
}
