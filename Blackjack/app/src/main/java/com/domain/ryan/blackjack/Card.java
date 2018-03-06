package com.domain.ryan.blackjack;

/**
 *     The card class represents a physical card.
 */

public class Card {

    private String suite;
    private int value;
    private int img;

    /**
     * Initializes a card with the correct suite value and image id
     *
     * @param _suite Suite of the card
     * @param _val Value of the card (Ace 0)
     * @param _img Image resource id
     */
    public Card(String _suite, int _val, int _img) {
        suite = _suite;
        if(_val >= 11){
            value = 10;
        }else if(_val == 0){
            value = 11;
        }else{
            value = _val + 1;
        }
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
