package com.pkkor.pandemic.services;

import com.pkkor.pandemic.enums.cards.CityCards;

public interface ResearchStationService {
    void add(CityCards cityCard);
    boolean contains(String location);
}
