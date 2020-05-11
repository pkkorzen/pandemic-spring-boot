package com.pkkor.pandemic.enums.cards;

import com.pkkor.pandemic.enums.color.Color;

public enum EventCards implements Card {
    RESILIENT_POPULATION(Color.GOLD),
    ONE_QUIET_NIGHT(Color.GOLD),
    FORECAST(Color.GOLD),
    AIRLIFT(Color.GOLD),
    GOVERNMENT_GRANT(Color.GOLD);

    private Color color;

    EventCards(Color color){
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
