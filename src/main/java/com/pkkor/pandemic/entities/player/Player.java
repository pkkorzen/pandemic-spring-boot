package com.pkkor.pandemic.entities.player;

import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;

public class Player {
    private int Id;
    private Characters character;
    private String city;
    private int actionsNumber;
    private Card[] cards;

    public Player(Characters character) {
        this.character = character;
        this.city = "Atlanta";
        this.actionsNumber = 4;
        this.cards = new Card[7];
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Characters getCharacter() {
        return character;
    }

    public void setCharacter(Characters character) {
        this.character = character;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getActionsNumber() {
        return actionsNumber;
    }

    public void setActionsNumber(int actionsNumber) {
        this.actionsNumber = actionsNumber;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}
