package com.pkkor.pandemic.services.impl;

import com.pkkor.pandemic.enums.cards.Card;
import com.pkkor.pandemic.services.PlayerDiscardPileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerDiscardPileServiceImpl implements PlayerDiscardPileService {
    private static List<Card> discardPile;

    static {
        discardPile = new ArrayList<>();
    }

    @Override
    public void addToDiscardPile(Card card) {
        discardPile.add(card);
    }
}
