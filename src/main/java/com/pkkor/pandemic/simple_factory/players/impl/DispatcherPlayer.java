package com.pkkor.pandemic.simple_factory.players.impl;

import com.pkkor.pandemic.actions.impl.basic.*;
import com.pkkor.pandemic.actions.impl.dispatcher.DispatcherAMoveAction;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;
import com.pkkor.pandemic.simple_factory.players.AbstractPlayer;

public class DispatcherPlayer extends AbstractPlayer {

    public DispatcherPlayer() {
        character = Characters.DISPATCHER;
        city = "Atlanta";
        actionsNumber = 4;
        cards = new Card[6];
        moveAction = new DispatcherAMoveAction();
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
}
