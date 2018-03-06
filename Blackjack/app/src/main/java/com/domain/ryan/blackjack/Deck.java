package com.domain.ryan.blackjack;

import android.util.Log;

import java.util.Arrays;

/**
 * Standard deck, modified for new use
 * @author groovyLlama devteam
 * @version 1.0
 */

public class Deck {

        // class constants
        private static final int SUITS = Card.suitAry.length;
        private static final int RANKS = Card.rankAry.length;
        private static final int SIZE = SUITS * RANKS;

        // class variables
        private static int deckCount;

        // instance variables
        private Card[] deck;

        // Constructors -----------------------------------------------------------
        /**
         * Creates and initializes a new deck of 52 standard playing cards.
         * Aces are low and no jokers are present.
         */
        public Deck() {

            deckCount = 0;
            deck = new Card[SIZE];
            init();
        }

        // Accessors --------------------------------------------------------------
        /**
         * Returns deck size.
         * @return deck size
         */
        public int size() {
            return SIZE;
        }

        /**
         * Returns number of cards that have been pulled from top of the deck.
         * @return deck count
         */
        public int getDeckCount() {
            return deckCount;
        }

        /**
         * Returns a card from the top of the deck.
         * @return top card
         */
        public Card getCard () {

            if (deckCount >= SIZE);
            return deck[deckCount++];
        }

        public boolean isEmpty() {
            return deckCount == SIZE;
        }

        // Functionality ----------------------------------------------------------
        /**
         * Initializes a deck of cards with proper suits and ranks.
         */
        private void init() {

            for (int i = 0; i < SIZE; i++) {
                deck[i] = new Card(i % RANKS, i / RANKS);
            }
        }

        /**
         * Shuffles deck of cards.
         */
        public void shuffle() {


            deckCount = 0;
            for (int i = 0; i < SIZE; i++) {

                int rand = i + (int) (Math.random() * (SIZE - i));
                Card temp = deck[rand];
                deck[rand] = deck[i];
                deck[i] = temp;
            }
        }

        /**
         * Creates a new deck and shuffles it
         */
        public void newDeck() {
            init();
            shuffle();
        }

        // Equality ---------------------------------------------------------------
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + Arrays.hashCode(deck);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Deck other = (Deck) obj;
            if (!Arrays.equals(deck, other.deck)) {
                return false;
            }
            return true;
        }
}
