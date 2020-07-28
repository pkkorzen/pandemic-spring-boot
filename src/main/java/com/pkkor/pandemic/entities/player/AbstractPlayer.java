package com.pkkor.pandemic.entities.player;

import com.pkkor.pandemic.actions.Action;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;

public abstract class AbstractPlayer {
    protected int id;
    protected Characters character;
    protected String city;
    protected int actionsNumber;
    protected Card[] cards;
    protected String name;
    protected Action moveAction;
    protected Action buildAction;
    protected Action treatAction;
    protected Action knowledgeSharingAction;
    protected Action cureAction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getMoveAction() {
        return moveAction;
    }

    public void setMoveAction(Action moveAction) {
        this.moveAction = moveAction;
    }

    public Action getBuildAction() {
        return buildAction;
    }

    public void setBuildAction(Action buildAction) {
        this.buildAction = buildAction;
    }

    public Action getTreatAction() {
        return treatAction;
    }

    public void setTreatAction(Action treatAction) {
        this.treatAction = treatAction;
    }

    public Action getKnowledgeSharingAction() {
        return knowledgeSharingAction;
    }

    public void setKnowledgeSharingAction(Action knowledgeSharingAction) {
        this.knowledgeSharingAction = knowledgeSharingAction;
    }

    public Action getCureAction() {
        return cureAction;
    }

    public void setCureAction(Action cureAction) {
        this.cureAction = cureAction;
    }

    public abstract void build();
    public abstract void cure();
    public abstract void move(String... args);
    public abstract void share();
    public abstract void treat();
}
