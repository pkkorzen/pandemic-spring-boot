package com.pkkor.pandemic.dto;

import com.pkkor.pandemic.entities.player.Player;

public class CharacterChoiceDTO {
    int pandemicNumber;
    int playerNumber;
    Player[] players;

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

    //TODO: needs to be changed to PlayerDTO
    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
}
