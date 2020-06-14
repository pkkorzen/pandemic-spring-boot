package com.pkkor.pandemic.simple_factory.players.impl;

import com.pkkor.pandemic.actions.impl.basic.*;
import com.pkkor.pandemic.actions.impl.operations_expert.OperationsExpertABuildAction;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;
import com.pkkor.pandemic.simple_factory.players.AbstractPlayer;

public class OperationsExpertPlayer extends AbstractPlayer {

    public OperationsExpertPlayer() {
        character = Characters.OPERATIONS_EXPERT;
        city = "Atlanta";
        actionsNumber = 4;
        cards = new Card[6];
        moveAction = new BasicMoveAction();
        buildAction = new OperationsExpertABuildAction();
        treatAction = new BasicTreatAction();
        knowledgeSharingAction = new BasicShareAction();
        cureAction = new BasicCureAction();
    }

    public OperationsExpertPlayer(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }
}
