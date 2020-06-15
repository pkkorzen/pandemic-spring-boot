package com.pkkor.pandemic.entities.player.impl;

import com.pkkor.pandemic.actions.impl.basic.*;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;
import com.pkkor.pandemic.entities.player.AbstractPlayer;

public class ContingencyPlannerPlayer extends AbstractPlayer {

    public ContingencyPlannerPlayer() {
        character = Characters.CONTINGENCY_PLANNER;
        city = "Atlanta";
        actionsNumber = 4;
        cards = new Card[7];
        moveAction = new BasicMoveAction();
        buildAction = new BasicBuildAction();
        treatAction = new BasicTreatAction();
        knowledgeSharingAction = new BasicShareAction();
        cureAction = new BasicCureAction();
    }

    public ContingencyPlannerPlayer(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }
}