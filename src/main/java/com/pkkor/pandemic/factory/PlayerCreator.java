package com.pkkor.pandemic.factory;

import com.pkkor.pandemic.entities.player.impl.*;
import com.pkkor.pandemic.enums.characters.Characters;
import com.pkkor.pandemic.entities.player.AbstractPlayer;
import org.springframework.stereotype.Component;

@Component
public class PlayerCreator {
    public AbstractPlayer createPlayer(Enum<Characters> character) {
        //TODO: somewhere there's need to be a logic for random choice as well, it might be in the Game class as it is now
        // but it depends on further development - model change, so just to remember to include it in the change
        if (Characters.SCIENTIST.equals(character)) {
            return new ScientistPlayer();
        } else if (Characters.RESEARCHER.equals(character)) {
            return new ResearcherPlayer();
        } else if (Characters.MEDIC.equals(character)) {
            return new MedicPlayer();
        } else if (Characters.DISPATCHER.equals(character)) {
            return new DispatcherPlayer();
        } else if (Characters.OPERATIONS_EXPERT.equals(character)) {
            return new OperationsExpertPlayer();
        } else if (Characters.QUARANTINE_SPECIALIST.equals(character)) {
            return new QuarantineSpecialistPlayer();
        } else if (Characters.CONTINGENCY_PLANNER.equals(character)) {
            return new ContingencyPlannerPlayer();
        } else {
            return null; //better to use an Exception
        }
    }

    public AbstractPlayer createPlayer(Enum<Characters> character, int id, String name) {
        if (Characters.SCIENTIST.equals(character)) {
            return new ScientistPlayer(id, name);
        } else if (Characters.RESEARCHER.equals(character)) {
            return new ResearcherPlayer(id, name);
        } else if (Characters.MEDIC.equals(character)) {
            return new MedicPlayer(id, name);
        } else if (Characters.DISPATCHER.equals(character)) {
            return new DispatcherPlayer(id, name);
        } else if (Characters.OPERATIONS_EXPERT.equals(character)) {
            return new OperationsExpertPlayer(id, name);
        } else if (Characters.QUARANTINE_SPECIALIST.equals(character)) {
            return new QuarantineSpecialistPlayer(id, name);
        } else if (Characters.CONTINGENCY_PLANNER.equals(character)) {
            return new ContingencyPlannerPlayer(id, name);
        } else {
            return null; //better to use an Exception
        }
    }
}
