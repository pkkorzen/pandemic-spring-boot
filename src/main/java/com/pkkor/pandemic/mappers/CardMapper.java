package com.pkkor.pandemic.mappers;

import com.pkkor.pandemic.dto.CardDTO;
import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.enums.cards.CityCards;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public Card convert(CardDTO cardDTO) {
        return CityCards.valueOf(cardDTO.getName());
    }

    public CardDTO convert(Card card) {
        return new CardDTO(card.getName(), card.getColor().name());
    }
}
