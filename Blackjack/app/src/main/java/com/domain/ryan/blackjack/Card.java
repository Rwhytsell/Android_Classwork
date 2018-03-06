package com.domain.ryan.blackjack;

/**
 *     The card class represents a physical card.
 */

public class Card {

    private String suite;
    private int value;
    private int img;

    public Card(String _suite, int _val, int _img) {
        suite = _suite;
        value = _val;
        img = _img;
    }

    /**
     * Used to get the suite of a card
     *
     * @return suite
     */

    public String getSuite() {
        return suite;
    }

    /**
     * Used to get the value of a card
     *
     * @return value
     */

    public int getValue() {
        return value;
    }

    /**
     * Used to get the image resource id of the card
     *
     * @return img
     */

    public int getImg() {
        return img;
    }


}
