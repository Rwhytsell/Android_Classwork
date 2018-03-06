package com.domain.ryan.blackjack;

import java.util.ArrayList;

/**
 * This class represents a physical player.
 * Mainly used for holding cards
 */

public class Player {

    private ArrayList<Card> cards;

    public Player() {
        cards = new ArrayList<Card>();
    }

    /**
     * Get the total value of the players hand
     *
     * @return int value of players hand
     */

    public int getTotalVal() {
        int val = 0;
        for (int i = 0; i < cards.size(); i++) {
            val += cards.get(i).getValue();
        }
        return val;
    }

    /**
     * Adds a card to the players hand
     *
     * @param c Card to be added
     */

    public void addCard(Card c) {
        cards.add(c);
    }

    /**
     * Gets all of the players cards
     *
     * @return cards The players cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }


}
