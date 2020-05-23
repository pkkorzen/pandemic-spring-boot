package com.pkkor.pandemic.main.game;

import com.pkkor.pandemic.dto.CharacterChoiceDTO;
import com.pkkor.pandemic.dto.PlayerDTO;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.cards.CityCards;
import com.pkkor.pandemic.enums.cards.EpidemicCards;
import com.pkkor.pandemic.enums.cards.EventCards;
import com.pkkor.pandemic.entities.player.Player;
import com.pkkor.pandemic.enums.characters.Characters;
import com.pkkor.pandemic.mappers.CharacterMapper;
import com.pkkor.pandemic.mappers.PlayerMapper;
import com.pkkor.pandemic.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class Game {
    private List<Card> playerDeck;
    private List<Card> infectionDeck;
    private List<Card> infectionDiscardPile;
    private List<Card> playerDiscardPile;
    private Queue<Player> playerOrder;
    private int outbreaksCounter;
    private int blueCubes = 24;
    private int blackCubes = 24;
    private int redCubes = 24;
    private int yellowCubes = 24;
    private Map<Card, Integer> infectedCities = new HashMap<>();
    private int infectionRate;
    private PlayerService playerService;
    private PlayerMapper playerMapper;
    private CharacterMapper characterMapper;

    @Autowired
    public Game (PlayerService playerService, PlayerMapper playerMapper, CharacterMapper characterMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
        this.characterMapper = characterMapper;
    }

    public void execute(CharacterChoiceDTO characterChoiceDTO) {
        initialise(characterChoiceDTO);
        dealCards(characterChoiceDTO);
        addEpidemicCards(characterChoiceDTO.getPandemicNumber());
        int counter = 3;
        while (counter > 0) {
            infectCities(3, counter);
            counter--;
        }
        orderPlayers();
    }

    private void initialise(CharacterChoiceDTO characterChoiceDTO) {
        playerService.clearPlayers();
        PlayerDTO[] playerDTOs = characterChoiceDTO.getPlayers();

        Set<String> charactersChosenString = Arrays
                .stream(playerDTOs)
                .map(PlayerDTO::getCharacter)
                .collect(Collectors.toSet());
        charactersChosenString.remove("Random");

        List<String> charactersLeft = new ArrayList<>(Arrays.asList(Characters.values()))
                .stream()
                .map(x -> characterMapper.convertCharacterToName(x))
                .collect(Collectors.toList());
        charactersLeft.removeAll(charactersChosenString);

        for (int i = 0; i < characterChoiceDTO.getPlayerNumber(); i++) {
            if (playerDTOs[i].getCharacter().equals("Random")) {
                Collections.shuffle(charactersLeft);
                playerDTOs[i].setCharacter(charactersLeft.get(0));
                charactersLeft.remove(0);
            }
            playerService.savePlayer(playerMapper.convert(playerDTOs[i]));
        }

        for (Player p : playerService.findAllPlayers()) {
            p.setActionsNumber(p.getCharacter().getActionsNumber());
        }

        playerDeck = new ArrayList<>(Arrays.asList(CityCards.values()));
        playerDeck.addAll(Arrays.asList(EventCards.values()));
        Collections.shuffle(playerDeck);

        infectionDeck = new ArrayList<>(Arrays.asList(CityCards.values()));
        Collections.shuffle(infectionDeck);

        for (Card c : CityCards.values()){
            infectedCities.put(c, 0);
        }
    }

    private void dealCards(CharacterChoiceDTO characterChoiceDTO) {
        int numberOfCards;
        int playerNumber = characterChoiceDTO.getPlayerNumber();
        if (playerNumber == 3) {
            numberOfCards = 3;
        } else {
            numberOfCards = playerNumber ^ 6;
        }
        List<Player> players = playerService.findAllPlayers();
        for (Player p : players) {
            p.setCards(new Card[p.getCharacter().getCardsNumber()]);
            for (int i = 0; i < numberOfCards; i++) {
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
        infectionDiscardPile = new ArrayList<>();
        for (int i = 0; i < numberOfCities; i++) {
            Card cardDrawn = infectionDeck.get(i);
            infectionDiscardPile.add(cardDrawn);
            infectedCities.put(cardDrawn, numberOfCubes);
            distributeCubes(cardDrawn, numberOfCubes);
        }
        infectionDeck.removeAll(infectionDiscardPile);
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

    private void orderPlayers() {
        playerOrder = new LinkedList<>();
        
        List<Player> players = new ArrayList<>(playerService.findAllPlayers());
        Collections.shuffle(players);

        for (Player p: players) {
            playerOrder.offer(p);
        }
    }
}
