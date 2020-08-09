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

    public String convertToNameString(Card card) {
        String[] characterParts = card.getName().split("_");
        StringBuilder cardNameSB = new StringBuilder();

        for (String characterPart : characterParts) {
            cardNameSB
                    .append(characterPart.charAt(0))
                    .append(characterPart.substring(1).toLowerCase())
                    .append(" ");
        }
        cardNameSB.deleteCharAt(cardNameSB.length() - 1);
        return cardNameSB.toString();
    }

    public Card convertFromNameString(String cardName) {
        String cardNameUpperCase = cardName.toUpperCase();
        String cardEnumName = cardNameUpperCase.replaceAll(" ", "_");
        return CityCards.valueOf(cardEnumName);
    }
}
