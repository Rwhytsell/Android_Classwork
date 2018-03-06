package com.domain.ryan.blackjack;

/**
 * Standard playing card, modified for new use
 * @author groovyLlama devteam
 * @version 1.0
 */
public class Card {


        // class constants
        static final String[] rankAry = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        static final String[] suitAry = { "d", "c", "h", "s" };

        static final int maxValue = rankAry.length;

        // class variables
        private static boolean debug = false;
        private static boolean unicode = false;

        // instance variables
        private int rank;
        private int suit;

// Constructors ---------------------------------------------------------------
        /**
         * Default card is the ace of diamonds.
         */
        public Card() {
            setRank(0);
            setSuit(0);
        }

        /**
         * Creates a playing card based on rank and suit as integers.
         * @param r rank from 0-12
         * @param s suit from 0-3
         */
        public Card(int r, int s) {
            setRank(r);
            setSuit(s);
        }

// Mutators -------------------------------------------------------------------
        /**
         * Sets card rank.
         * @param newRank new card rank as integer
         */
        private void setRank(int newRank) {
            rank = newRank;
        }

        /**
         * Sets card suit.
         * @param newSuit new card suit as integer
         */
        private void setSuit(int newSuit) {
            suit = newSuit;
        }

// Accessors ------------------------------------------------------------------
        /**
         * Returns rank as an integer.
         * @return rank integer
         */
        public int getRank() {
            return rank;
        }

        /**
         * Returns face value of card.
         * @return face value
         */
        public int getValue() {
            return rank + 1;
        }

        /**
         * Returns suit as an integer.
         * @return suit integer
         */
        public int getSuit() {
            return suit;
        }

        /**
         * Returns rank as a proper playing card rank (A - K)
         * @return rank string
         */
        public String getRankString() {
            return rankAry[rank];
        }

        /**
         * Returns suit as a word.
         * @return suit string
         */
        public String getSuitString() {
            return suitAry[suit];
        }

        /**
         * Returns string with proper rank and suit in words.
         * @return name string
         */
        public String getName() {
            return rankAry[rank] + " of " + suitAry[suit];
        }

        /**
         * Returns true if suit is black,
         * false if suit is red.
         * @return true if suit is black
         */
        public boolean isBlack() {
            return suit == 1 || suit == 3;
        }

        /**
         * Returns face value of highest card (king).
         * @return face value of highest card
         */
        public static int getMaxValue() {
            return maxValue;
        }

        @Override
        public int hashCode() {

            final int prime = 31;
            int result = 1;
            result = prime * result + rank;
            result = prime * result + suit;
            return result;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            return true;
        }
}
