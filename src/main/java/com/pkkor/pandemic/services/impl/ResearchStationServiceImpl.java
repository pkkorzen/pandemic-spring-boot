package com.pkkor.pandemic.services.impl;

import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.cards.CityCards;
import com.pkkor.pandemic.mappers.CardMapper;
import com.pkkor.pandemic.services.ResearchStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class ResearchStationServiceImpl implements ResearchStationService {

    private static Set<Card> researchStations;
    private CardMapper cardMapper;

    @Autowired
    public ResearchStationServiceImpl(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    static {
        researchStations = new HashSet<>();
    }
    @Override
    public void add(CityCards cityCard) {
        researchStations.add(cityCard);
    }

    @Override
    public boolean contains(String location) {
        Card card = cardMapper.convertFromNameString(location);
        return researchStations.contains(card);
    }
}
