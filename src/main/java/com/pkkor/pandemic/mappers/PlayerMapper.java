package com.pkkor.pandemic.mappers;

import com.pkkor.pandemic.dto.CardDTO;
import com.pkkor.pandemic.dto.PlayerDTO;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;
import com.pkkor.pandemic.factory.PlayerCreator;
import com.pkkor.pandemic.entities.player.AbstractPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
public class PlayerMapper {

    private CardMapper cardMapper;
    private CharacterMapper characterMapper;
    private PlayerCreator playerCreator;

    @Autowired
    public PlayerMapper(CardMapper cardMapper, CharacterMapper characterMapper, PlayerCreator playerCreator) {
        this.cardMapper = cardMapper;
        this.characterMapper = characterMapper;
        this.playerCreator = playerCreator;
    }

    public AbstractPlayer convert (PlayerDTO playerDTO) {
        int numberIndex = playerDTO.getId().length() - 1;
        String stringId = playerDTO.getId().substring(numberIndex);
        Characters character = characterMapper.convertNameToCharacter(playerDTO.getCharacter());
        String playerName = playerDTO.getName();
        AbstractPlayer player = playerCreator.createPlayer(character, Integer.parseInt(stringId), playerName);
        player.setCity(playerDTO.getCity());
        
        if (playerDTO.getCards() != null) {
            Card[] cards = Arrays
                    .stream(playerDTO.getCards())
                    .filter(Objects::nonNull)
                    .map(x -> cardMapper.convert(x))
                    .toArray(Card[]::new);
            player.setCards(cards);
        }

        return player;
    }

    public PlayerDTO convert (AbstractPlayer player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId("player" + player.getId());
        playerDTO.setActionsNumber(player.getActionsNumber());
        String characterName = characterMapper.convertCharacterToName(player.getCharacter());
        playerDTO.setCharacter(characterName);
        playerDTO.setCity(player.getCity());
        playerDTO.setName(player.getName());

        if (player.getCards() != null) {
            CardDTO[] cards = Arrays
                    .stream(player.getCards())
                    .filter(Objects::nonNull)
                    .map(x -> cardMapper.convert(x))
                    .toArray(CardDTO[]::new);
            playerDTO.setCards(cards);
        }

        return playerDTO;
    }
}
