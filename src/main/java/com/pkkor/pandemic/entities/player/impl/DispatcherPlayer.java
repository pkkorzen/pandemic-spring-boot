package com.pkkor.pandemic.entities.player.impl;

import com.pkkor.pandemic.actions.impl.basic.*;
import com.pkkor.pandemic.actions.impl.dispatcher.DispatcherMoveAction;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;
import com.pkkor.pandemic.entities.player.AbstractPlayer;

public class DispatcherPlayer extends AbstractPlayer {

    public DispatcherPlayer() {
        character = Characters.DISPATCHER;
        city = "Atlanta";
        actionsNumber = 4;
        cards = new Card[7];
        moveAction = new DispatcherMoveAction();
        buildAction = new BasicBuildAction();
        treatAction = new BasicTreatAction();
        knowledgeSharingAction = new BasicShareAction();
        cureAction = new BasicCureAction();
    }

    public DispatcherPlayer(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    @Override
    public void build() {
        buildAction.execute();
    }

    @Override
    public void cure() {
        cureAction.execute();
    }

    @Override
    public void move() {
        moveAction.execute();
    }

    @Override
    public void share() {
        knowledgeSharingAction.execute();
    }

    @Override
    public void treat() {
        treatAction.execute();
    }
}
