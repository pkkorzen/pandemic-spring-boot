package com.pkkor.pandemic.entities.player;

import com.pkkor.pandemic.actions.*;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.cards.CityCards;
import com.pkkor.pandemic.enums.characters.Characters;

public class Player {
    private Characters character;
    private Treatable treatmentAction;
    private Shareable sharingAction;
    private Movable movingAction;
    private Cureable curingAction;
    private Buildable buildingAction;
    private CityCards city;
    private int actionsNumber;
    private Card[] cards;

    public Player(Characters character){
        this.character = character;
        this.treatmentAction = character.getDiseaseTreatmentAction();
        this.sharingAction = character.getKnowledgeSharingAction();
        this.movingAction = character.getMovingAction();
        this.curingAction = character.getCuringAction();
        this.buildingAction = character.getBuildingAction();
        this.city = CityCards.ATLANTA;
        this.actionsNumber = 4;
        this.cards = new Card[7];
    }

    public Card[] getCards() {
        return cards;
    }
}
