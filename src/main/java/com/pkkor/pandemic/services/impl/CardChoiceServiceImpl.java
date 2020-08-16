package com.pkkor.pandemic.services.impl;

import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.services.CardChoiceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CardChoiceServiceImpl implements CardChoiceService {
    // list or maybe just a simple variable Card??
    private static List<Card> cardList;

    static {
        cardList = new ArrayList<>();
    }

    @Override
    public List<Card> getCards() {
        return cardList;
    }

    @Override
    public void addCard(Card card) {
        cardList.add(card);
    }

    @Override
    public void clear() {
        cardList.clear();
    }
}
