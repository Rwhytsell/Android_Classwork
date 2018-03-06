package com.domain.ryan.blackjack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * The main game activity that handles the view for the actual game
 */

public class GameActivity extends AppCompatActivity {

    Deck deck = new Deck();
    Player dealer = new Player();
    Player player = new Player();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);

        final Button hitButton = findViewById(R.id.hit);
        hitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hit();
            }
        });

        final Button stayButton = findViewById(R.id.stay);
        stayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stay();
            }
        });

        deck.shuffle();
        deal();
        update();

    }

    /**
     * The initial deal of cards
     */

    public void deal() {
        player.addCard(deck.draw());
        dealer.addCard(deck.draw());
        player.addCard(deck.draw());
        dealer.addCard(deck.draw());
    }

    /**
     * Called when user clicks hit button
     */

    public void hit() {
        player.addCard(deck.draw());
        update();
    }

    /**
     * Called when user wants to stay
     * This finishes the round
     */
    public void stay() {
        int playerScore = player.getTotalVal();
        int dealerScore = dealer.getTotalVal();
        Log.e("Scores", "Player: " + playerScore + " Dealer: " + dealerScore);
    }

    /**
     * This removes all of the cards and replaces them with the cards currently in the model
     */

    public void update() {
        //TODO check player score for bust
        LinearLayout playerContent = findViewById(R.id.player_cards);
        LinearLayout dealerContent = findViewById(R.id.dealer_cards);
        playerContent.removeAllViews();
        dealerContent.removeAllViews();

        for (int i = 0; i < dealer.getCards().size(); i++) {
            ImageView newCardView = new ImageView(this);
            newCardView.setBackgroundResource(dealer.getCards().get(i).getImg());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200, 280);
            lp.setMargins(-60, 0, 0, 0);
            lp.gravity= Gravity.CENTER;
            newCardView.setLayoutParams(lp);
            dealerContent.addView(newCardView);

        }

        for (int i = 0; i < player.getCards().size(); i++) {
            ImageView newCardView = new ImageView(this);
            newCardView.setBackgroundResource(player.getCards().get(i).getImg());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200, 280);
            lp.setMargins(-60, 0, 0, 0);
            lp.gravity= Gravity.CENTER;
            newCardView.setLayoutParams(lp);
            playerContent.addView(newCardView);

        }
    }
}
