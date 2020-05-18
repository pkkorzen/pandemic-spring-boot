package com.pkkor.pandemic.mappers;

import com.pkkor.pandemic.dto.CardDTO;
import com.pkkor.pandemic.dto.PlayerDTO;
import com.pkkor.pandemic.entities.player.Player;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.characters.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PlayerMapper {

    private CardMapper cardMapper;
    private CharacterMapper characterMapper;

    @Autowired
    public PlayerMapper(CardMapper cardMapper, CharacterMapper characterMapper) {
        this.cardMapper = cardMapper;
        this.characterMapper = characterMapper;
    }

    public Player convert (PlayerDTO playerDTO) {
        Player player = new Player();
        int numberIndex = playerDTO.getId().length() - 1;
        String stringId = playerDTO.getId().substring(numberIndex);
        player.setId(Integer.parseInt(stringId));
        player.setCity(playerDTO.getCity());
        player.setActionsNumber(playerDTO.getActionsNumber());
        
        if (playerDTO.getCards() != null) {
            Card[] cards = (Card[]) Arrays
                    .stream(playerDTO.getCards())
                    .map(x -> cardMapper.convert(x))
                    .toArray();
            player.setCards(cards);
        }

        Characters character = characterMapper.convertNameToCharacter(playerDTO.getCharacter());
        player.setCharacter(character);
        player.setName(playerDTO.getName());
        return player;
    }

    public PlayerDTO convert (Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId("player" + player.getId());
        playerDTO.setActionsNumber(player.getActionsNumber());
        String characterName = characterMapper.convertCharacterToName(player.getCharacter());
        playerDTO.setCharacter(characterName);
        playerDTO.setCity(player.getCity());
        playerDTO.setName(player.getName());

        if (player.getCards() != null) {
            CardDTO[] cards = (CardDTO[]) Arrays
                    .stream(player.getCards())
                    .map(x -> cardMapper.convert(x))
                    .toArray();
            playerDTO.setCards(cards);
        }

        return playerDTO;
    }
}
