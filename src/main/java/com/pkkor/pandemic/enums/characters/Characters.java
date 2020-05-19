package com.pkkor.pandemic.enums.characters;

import com.pkkor.pandemic.actions.*;
import com.pkkor.pandemic.actions.impl.basic.*;
import com.pkkor.pandemic.actions.impl.dispatcher.DispatcherMoveAction;
import com.pkkor.pandemic.actions.impl.medic.MedicTreatmentAction;
import com.pkkor.pandemic.actions.impl.operations_expert.OperationsExpertBuildAction;
import com.pkkor.pandemic.actions.impl.researcher.ResearcherShareAction;
import com.pkkor.pandemic.actions.impl.scientist.ScientistCureAction;

public enum Characters {
    SCIENTIST(new TreatmentAction(), new ShareAction(), new MoveAction(), new ScientistCureAction(), new BuildAction(), EnumConstants.BASIC_ACTIONS_NUMBER, EnumConstants.BASIC_CARDS_NUMBER),
    RESEARCHER(new TreatmentAction(), new ResearcherShareAction(), new MoveAction(), new CureAction(), new BuildAction(), EnumConstants.BASIC_ACTIONS_NUMBER, EnumConstants.BASIC_CARDS_NUMBER),
    MEDIC(new MedicTreatmentAction(), new ShareAction(), new MoveAction(), new CureAction(), new BuildAction(), EnumConstants.BASIC_ACTIONS_NUMBER, EnumConstants.BASIC_CARDS_NUMBER),
    DISPATCHER(new TreatmentAction(), new ShareAction(), new DispatcherMoveAction(), new CureAction(), new BuildAction(), EnumConstants.BASIC_ACTIONS_NUMBER, EnumConstants.BASIC_CARDS_NUMBER),
    OPERATIONS_EXPERT(new TreatmentAction(), new ShareAction(), new MoveAction(), new CureAction(), new OperationsExpertBuildAction(), EnumConstants.BASIC_ACTIONS_NUMBER, EnumConstants.BASIC_CARDS_NUMBER),
    QUARANTINE_SPECIALIST(new TreatmentAction(), new ShareAction(), new MoveAction(), new CureAction(), new BuildAction(), EnumConstants.BASIC_ACTIONS_NUMBER, EnumConstants.BASIC_CARDS_NUMBER),
    CONTINGENCY_PLANNER(new TreatmentAction(), new ShareAction(), new MoveAction(), new CureAction(), new BuildAction(), EnumConstants.BASIC_ACTIONS_NUMBER, EnumConstants.BASIC_CARDS_NUMBER);

    private Treatable diseaseTreatmentAction;
    private Shareable knowledgeSharingAction;
    private Movable movingAction;
    private Cureable curingAction;
    private Buildable buildingAction;
    private int actionsNumber;
    private int cardsNumber;

    private Characters(Treatable diseaseTreatmentAction, Shareable knowledgeSharingAction, Movable movingAction,
                       Cureable curingAction, Buildable buildingAction, int actionsNumber, int cardsNumber){
        this.diseaseTreatmentAction = diseaseTreatmentAction;
        this.knowledgeSharingAction = knowledgeSharingAction;
        this.movingAction = movingAction;
        this.curingAction = curingAction;
        this.buildingAction = buildingAction;
        this.actionsNumber = actionsNumber;
        this.cardsNumber = cardsNumber;
    }

    public Treatable getDiseaseTreatmentAction() {
        return diseaseTreatmentAction;
    }

    public Shareable getKnowledgeSharingAction() {
        return knowledgeSharingAction;
    }

    public Movable getMovingAction() {
        return movingAction;
    }

    public Cureable getCuringAction() {
        return curingAction;
    }

    public Buildable getBuildingAction() {
        return buildingAction;
    }

    public String getName () {
        return this.name();
    }

    public int getActionsNumber() {
        return actionsNumber;
    }

    public void setActionsNumber(int actionsNumber) {
        this.actionsNumber = actionsNumber;
    }

    public int getCardsNumber() {
        return cardsNumber;
    }

    public void setCardsNumber(int cardsNumber) {
        this.cardsNumber = cardsNumber;
    }

    interface EnumConstants {
        int BASIC_ACTIONS_NUMBER = 4;
        int BASIC_CARDS_NUMBER = 7;
    }
}
