package com.pkkor.pandemic.services.impl;

import com.pkkor.pandemic.enums.cards.CityCards;
import com.pkkor.pandemic.services.ResearchStationService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class ResearchStationServiceImpl implements ResearchStationService {

    private static Set<CityCards> researchStations;

    static {
        researchStations = new HashSet<>();
    }
    @Override
    public void add(CityCards cityCard) {
        researchStations.add(cityCard);
    }

    @Override
    public boolean contains(String location) {
        return researchStations.contains(CityCards.valueOf(location));
    }
}
