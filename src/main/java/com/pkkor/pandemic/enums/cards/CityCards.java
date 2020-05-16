package com.pkkor.pandemic.enums.cards;

import com.pkkor.pandemic.enums.color.Color;

public enum CityCards implements Card {
    ATLANTA(Color.BLUE),
    SAN_FRANCISCO(Color.BLUE),
    CHICAGO(Color.BLUE),
    MONTREAL(Color.BLUE),
    WASHINGTON(Color.BLUE),
    NEW_YORK(Color.BLUE),
    LONDON(Color.BLUE),
    ESSEN(Color.BLUE),
    PETERSBURG(Color.BLUE),
    MADRID(Color.BLUE),
    PARIS(Color.BLUE),
    MILAN(Color.BLUE),
    ALGIERS(Color.BLACK),
    ISTANBUL(Color.BLACK),
    MOSCOW(Color.BLACK),
    CAIRO(Color.BLACK),
    BAGHDAD(Color.BLACK),
    TEHRAN(Color.BLACK),
    RIYADH(Color.BLACK),
    KARACHI(Color.BLACK),
    DELHI(Color.BLACK),
    MUMBAI(Color.BLACK),
    CHENAI(Color.BLACK),
    KOLKATA(Color.BLACK),
    JAKARTA(Color.RED),
    BANGKOK(Color.RED),
    HONGKONG(Color.RED),
    HO_CHI_MINH_CITY(Color.RED),
    MANILA(Color.RED),
    SYDNEY(Color.RED),
    TAIPEI(Color.RED),
    SHANGHAI(Color.RED),
    BEIJING(Color.RED),
    SEUL(Color.RED),
    TOKYO(Color.RED),
    OSAKA(Color.RED),
    LOS_ANGELES(Color.YELLOW),
    MEXICO_CITY(Color.YELLOW),
    MIAMI(Color.YELLOW),
    BOGOTA(Color.YELLOW),
    LIMA(Color.YELLOW),
    SANTIAGO(Color.YELLOW),
    BUENOS_AIRES(Color.YELLOW),
    SAO_PAULO(Color.YELLOW),
    LAGOS(Color.YELLOW),
    KINSHASA(Color.YELLOW),
    JOHANNESBURG(Color.YELLOW),
    CHARTUM(Color.YELLOW);

    private Color color;
    CityCards(Color color){
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public Color getColor(){
        return color;
    }
}
