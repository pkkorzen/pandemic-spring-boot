package com.pkkor.pandemic.enums.characters;

import com.pkkor.pandemic.actions.*;
import com.pkkor.pandemic.actions.impl.basic.*;
import com.pkkor.pandemic.actions.impl.dispatcher.DispatcherMoveAction;
import com.pkkor.pandemic.actions.impl.medic.MedicTreatmentAction;
import com.pkkor.pandemic.actions.impl.operations_expert.OperationsExpertBuildAction;
import com.pkkor.pandemic.actions.impl.researcher.ResearcherShareAction;
import com.pkkor.pandemic.actions.impl.scientist.ScientistCureAction;

public enum Characters {
    SCIENTIST(new TreatmentAction(), new ShareAction(), new MoveAction(), new ScientistCureAction(), new BuildAction()),
    RESEARCHER(new TreatmentAction(), new ResearcherShareAction(), new MoveAction(), new CureAction(), new BuildAction()),
    MEDIC(new MedicTreatmentAction(), new ShareAction(), new MoveAction(), new CureAction(), new BuildAction()),
    DISPATCHER(new TreatmentAction(), new ShareAction(), new DispatcherMoveAction(), new CureAction(), new BuildAction()),
    OPERATIONS_EXPERT(new TreatmentAction(), new ShareAction(), new MoveAction(), new CureAction(), new OperationsExpertBuildAction()),
    QUARANTINE_SPECIALIST(new TreatmentAction(), new ShareAction(), new MoveAction(), new CureAction(), new BuildAction()),
    CONTINGENCY_PLANNER(new TreatmentAction(), new ShareAction(), new MoveAction(), new CureAction(), new BuildAction());

    private Treatable diseaseTreatmentAction;
    private Shareable knowledgeSharingAction;
    private Movable movingAction;
    private Cureable curingAction;
    private Buildable buildingAction;

    private Characters(Treatable diseaseTreatmentAction, Shareable knowledgeSharingAction, Movable movingAction, Cureable curingAction, Buildable buildingAction){
        this.diseaseTreatmentAction = diseaseTreatmentAction;
        this.knowledgeSharingAction = knowledgeSharingAction;
        this.movingAction = movingAction;
        this.curingAction = curingAction;
        this.buildingAction = buildingAction;
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
}
