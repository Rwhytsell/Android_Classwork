package com.domain.ryan.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Deck playingDeck = new Deck();

        playingDeck.newDeck();

        Log.e("Debug", playingDeck.toString());
    }
}
