package com.pkkor.pandemic.enums.cards;

import com.pkkor.pandemic.enums.color.Color;

public enum EpidemicCards implements Card {
    EPIDEMIC(Color.GREEN);

    private Color color;

    EpidemicCards(Color color){
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
