package com.pkkor.pandemic.actions.impl.operations_expert;

import com.pkkor.pandemic.actions.AbstractMoveAction;
import com.pkkor.pandemic.entities.player.AbstractPlayer;
import com.pkkor.pandemic.services.ResearchStationService;
import com.pkkor.pandemic.utils.SpringApplicationContext;

public class OperationsExpertMoveAction extends AbstractMoveAction {

    @Override
    protected boolean specialMoveValid(AbstractPlayer player, AbstractPlayer playerToMove, String location) {
        ResearchStationService researchStationService = (ResearchStationService) SpringApplicationContext.getBean("researchStationServiceImpl");
        return researchStationService.contains(player.getCity());
    }

    @Override
    protected void specialMove(AbstractPlayer player, AbstractPlayer playerToMove, String location) {

    }
}
