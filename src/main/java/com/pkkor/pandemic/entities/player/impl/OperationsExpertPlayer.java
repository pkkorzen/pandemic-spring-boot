package com.pkkor.pandemic.entities.player.impl;

import com.pkkor.pandemic.actions.impl.basic.*;
import com.pkkor.pandemic.actions.impl.operations_expert.OperationsExpertBuildAction;
import com.pkkor.pandemic.actions.impl.operations_expert.OperationsExpertMoveAction;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;
import com.pkkor.pandemic.entities.player.AbstractPlayer;

public class OperationsExpertPlayer extends AbstractPlayer {

    public OperationsExpertPlayer() {
        character = Characters.OPERATIONS_EXPERT;
        city = "Atlanta";
        actionsNumber = 4;
        cards = new Card[7];
        moveAction = new OperationsExpertMoveAction();
        buildAction = new OperationsExpertBuildAction();
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
