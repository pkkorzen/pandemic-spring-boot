package com.pkkor.pandemic.services;

import com.pkkor.pandemic.enums.cards.Card;

import java.util.List;

public interface CardChoiceService {
    List<Card> getCards();
    void addCard(Card card);
    void clear();
}
