package com.pkkor.pandemic.dto;

public class CharacterChoiceDTO {
    int pandemicNumber;
    int playerNumber;
    PlayerDTO[] playerDTOs;

    public int getPandemicNumber() {
        return pandemicNumber;
    }

    public void setPandemicNumber(int pandemicNumber) {
        this.pandemicNumber = pandemicNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public PlayerDTO[] getPlayers() {
        return playerDTOs;
    }

    public void setPlayers(PlayerDTO[] playerDTOs) {
        this.playerDTOs = playerDTOs;
    }
}
