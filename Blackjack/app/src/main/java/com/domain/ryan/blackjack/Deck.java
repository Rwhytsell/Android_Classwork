package com.domain.ryan.blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The deck class representing a physical deck of cards
 */
public class Deck {
    private ArrayList<Card> cards;

    /**
     * Initializes a new deck with 52 cards (No Jokers)
     */
    public Deck() {
        cards = new ArrayList<Card>();
        String[] suites = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                switch(i) {
                    case 0:
                        switch(j) {
                            case 0:
                                cards.add(new Card(suites[i], j, R.drawable.heartace));
                                break;
                            case 1:
                                cards.add(new Card(suites[i], j,  R.drawable.heart2));
                                break;
                            case 2:
                                cards.add(new Card(suites[i], j,  R.drawable.heart3));
                                break;
                            case 3:
                                cards.add(new Card(suites[i], j,  R.drawable.heart4));
                                break;
                            case 4:
                                cards.add(new Card(suites[i], j,  R.drawable.heart5));
                                break;
                            case 5:
                                cards.add(new Card(suites[i], j,  R.drawable.heart6));
                                break;
                            case 6:
                                cards.add(new Card(suites[i], j,  R.drawable.heart7));
                                break;
                            case 7:
                                cards.add(new Card(suites[i], j,  R.drawable.heart8));
                                break;
                            case 8:
                                cards.add(new Card(suites[i], j,  R.drawable.heart9));
                                break;
                            case 9:
                                cards.add(new Card(suites[i], j,  R.drawable.heart10));
                                break;
                            case 10:
                                cards.add(new Card(suites[i], j,  R.drawable.heartjack));
                                break;
                            case 11:
                                cards.add(new Card(suites[i], j,  R.drawable.heartqueen));
                                break;
                            case 12:
                                cards.add(new Card(suites[i], j,  R.drawable.heartking));
                                break;

                        }
                        break;
                    case 1:
                        switch(j) {
                            case 0:
                                cards.add(new Card(suites[i], j,  R.drawable.diamondace));
                                break;
                            case 1:
                                cards.add(new Card(suites[i], j,  R.drawable.diamond2));
                                break;
                            case 2:
                                cards.add(new Card(suites[i], j,  R.drawable.diamond3));
                                break;
                            case 3:
                                cards.add(new Card(suites[i], j,  R.drawable.diamond4));
                                break;
                            case 4:
                                cards.add(new Card(suites[i], j,  R.drawable.diamond5));
                                break;
                            case 5:
                                cards.add(new Card(suites[i], j,  R.drawable.diamond6));
                                break;
                            case 6:
                                cards.add(new Card(suites[i], j,  R.drawable.diamond7));
                                break;
                            case 7:
                                cards.add(new Card(suites[i], j,  R.drawable.diamond8));
                                break;
                            case 8:
                                cards.add(new Card(suites[i], j,  R.drawable.diamond9));
                                break;
                            case 9:
                                cards.add(new Card(suites[i], j,  R.drawable.diamond10));
                                break;
                            case 10:
                                cards.add(new Card(suites[i], j,  R.drawable.diamondjack));
                                break;
                            case 11:
                                cards.add(new Card(suites[i], j,  R.drawable.diamondqueen));
                                break;
                            case 12:
                                cards.add(new Card(suites[i], j,  R.drawable.diamondking));
                                break;

                        }
                        break;
                    case 2:
                        switch(j) {
                            case 0:
                                cards.add(new Card(suites[i], j,  R.drawable.clubace));
                                break;
                            case 1:
                                cards.add(new Card(suites[i], j,  R.drawable.club2));
                                break;
                            case 2:
                                cards.add(new Card(suites[i], j,  R.drawable.club3));
                                break;
                            case 3:
                                cards.add(new Card(suites[i], j,  R.drawable.club4));
                                break;
                            case 4:
                                cards.add(new Card(suites[i], j,  R.drawable.club5));
                                break;
                            case 5:
                                cards.add(new Card(suites[i], j,  R.drawable.club6));
                                break;
                            case 6:
                                cards.add(new Card(suites[i], j,  R.drawable.club7));
                                break;
                            case 7:
                                cards.add(new Card(suites[i], j,  R.drawable.club8));
                                break;
                            case 8:
                                cards.add(new Card(suites[i], j,  R.drawable.club9));
                                break;
                            case 9:
                                cards.add(new Card(suites[i], j,  R.drawable.club10));
                                break;
                            case 10:
                                cards.add(new Card(suites[i], j,  R.drawable.clubjack));
                                break;
                            case 11:
                                cards.add(new Card(suites[i], j,  R.drawable.clubqueen));
                                break;
                            case 12:
                                cards.add(new Card(suites[i], j,  R.drawable.clubking));
                                break;

                        }
                        break;
                    case 3:
                        switch(j) {
                            case 0:
                                cards.add(new Card(suites[i], j,  R.drawable.spadeace));
                                break;
                            case 1:
                                cards.add(new Card(suites[i], j,  R.drawable.spade2));
                                break;
                            case 2:
                                cards.add(new Card(suites[i], j,  R.drawable.spade3));
                                break;
                            case 3:
                                cards.add(new Card(suites[i], j,  R.drawable.spade4));
                                break;
                            case 4:
                                cards.add(new Card(suites[i], j,  R.drawable.spade5));
                                break;
                            case 5:
                                cards.add(new Card(suites[i], j,  R.drawable.spade6));
                                break;
                            case 6:
                                cards.add(new Card(suites[i], j,  R.drawable.spade7));
                                break;
                            case 7:
                                cards.add(new Card(suites[i], j,  R.drawable.spade8));
                                break;
                            case 8:
                                cards.add(new Card(suites[i], j,  R.drawable.spade9));
                                break;
                            case 9:
                                cards.add(new Card(suites[i], j,  R.drawable.spade10));
                                break;
                            case 10:
                                cards.add(new Card(suites[i], j,  R.drawable.spadejack));
                                break;
                            case 11:
                                cards.add(new Card(suites[i], j,  R.drawable.spadequeen));
                                break;
                            case 12:
                                cards.add(new Card(suites[i], j,  R.drawable.spadeking));
                                break;

                        }


                }
            }
        }

    }

    /**
     * Returns the full deck of cards
     *
     * @return card array
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Shuffles deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Removes the top card from the deck and returns it
     *
     * @return Card Top card on the deck
     */
    public Card draw() {
        return cards.remove(0);
    }

}
