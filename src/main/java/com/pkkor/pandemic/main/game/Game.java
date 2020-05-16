package com.pkkor.pandemic.main.game;

import com.pkkor.pandemic.dto.CharacterChoiceDTO;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.cards.CityCards;
import com.pkkor.pandemic.enums.cards.EpidemicCards;
import com.pkkor.pandemic.enums.cards.EventCards;
import com.pkkor.pandemic.entities.player.Player;
import com.pkkor.pandemic.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class Game {
    private List<Card> playerDeck;
    private List<Card> infectionDeck;
    private List<Player> players;
    private List<Card> infectionDiscardPile;
    private List<Card> playerDiscardPile;
    private int outbreaksCounter;
    private int blueCubes = 24;
    private int blackCubes = 24;
    private int redCubes = 24;
    private int yellowCubes = 24;
    private Map<Card, Integer> infectedCities = new HashMap<>();
    private int infectionRate;
    private PlayerService playerService;

    @Autowired
    public Game (PlayerService playerService) {
        this.playerService = playerService;
    }

    public void execute(CharacterChoiceDTO characterChoiceDTO) {
        initialise(characterChoiceDTO);
        dealCards();
        addEpidemicCards(characterChoiceDTO.getPandemicNumber());
        int counter = 3;
        while (counter > 0){
            infectCities(3, counter);
            counter--;
        }
    }

    private void initialise(CharacterChoiceDTO characterChoiceDTO) {
        //TODO: needs to use PlayerDTO coming from characterChoiceDTO (changes in CharacterChoiceDTO also required)
        //TODO: code needs to be changed to be able to properly create players from PlayerDTO
        //TODO: conversion needs to be considered using Player and Card mappers
        for (int i = 1; i <= characterChoiceDTO.getPlayerNumber(); i++) {
            Player[] players = characterChoiceDTO.getPlayers();
            playerService.savePlayer(players[i]);
        }
        playerDeck = Arrays.asList(CityCards.values());
        playerDeck.addAll(Arrays.asList(EventCards.values()));
        Collections.shuffle(playerDeck);

        infectionDeck = Arrays.asList(CityCards.values());
        Collections.shuffle(infectionDeck);

        for (Card c : CityCards.values()){
            infectedCities.put(c, 0);
        }
    }

    private void dealCards() {
        //TODO: need to resolve the number issue
        //TODO: this is dependant on playerNumber
        int numberOfCards = 2;
        for (Player p : players){
            for (int i = 0; i < numberOfCards; i++){
                p.getCards()[i] = playerDeck.get(0);
                playerDeck.remove(0);
            }
        }
    }

    private void addEpidemicCards(int epidemicNumber) {
        List<List<Card>> partialDecks = new ArrayList<>();
        int partialDeckSize = playerDeck.size() / epidemicNumber;
        int remainingCardsNumber = playerDeck.size() % epidemicNumber;
        for (int i = remainingCardsNumber; i < epidemicNumber; i++){
            partialDecks.add(new ArrayList<>(playerDeck.subList(i, i+partialDeckSize)));
        }
        //adding remaining cards to the first partialDeck
        for (int i = 0; i < remainingCardsNumber; i++){
            List<Card> firstPartialDeck = partialDecks.get(0);
            firstPartialDeck.add(playerDeck.get(i));
        }
        playerDeck.clear();

        for (List<Card> l : partialDecks){
            l.add(EpidemicCards.EPIDEMIC);
            Collections.shuffle(l);
            playerDeck.addAll(l);
        }
    }

    private void infectCities(int numberOfCities, int numberOfCubes) {
        for (int i = 0; i < numberOfCities; i++){
            Card cardDrawn = infectionDeck.get(i);
            infectionDiscardPile.add(cardDrawn);
            infectedCities.put(cardDrawn, numberOfCubes);
            distributeCubes(cardDrawn, numberOfCubes);
        }
    }

    private void distributeCubes(Card cardDrawn, int numberOfCubes) {
        switch (cardDrawn.getColor()){
            case BLUE: blueCubes =- numberOfCubes;
            if (blueCubes < 0 ){
                break;
            }
            case BLACK: blackCubes =- numberOfCubes;
            if (blackCubes < 0){
                break;
            }
            case RED: redCubes =- numberOfCubes;
            if (redCubes < 0){
                break;
            }
            case YELLOW: yellowCubes =- numberOfCubes;
            if (yellowCubes < 0){
                break;
            }
        }
    }
}
