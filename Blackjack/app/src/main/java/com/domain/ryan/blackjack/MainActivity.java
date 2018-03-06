package com.domain.ryan.blackjack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Entrypoint into the app
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newGame();
            }
        });

    }

    /**
     * Called to start a new game
     */

    public void newGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
