package com.example.ethan.chapter6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    UserData ud = new UserData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final TextView guests = findViewById(R.id.GuestsNumber);
        final SeekBar guestslider = findViewById(R.id.GuestInput);

        guests.setText(String.valueOf(guestslider.getProgress()));

        guestslider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                guests.setText(String.valueOf(i));
                guestsChanged(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final TextView tip = findViewById(R.id.TipNumber);
        final SeekBar tipslider = findViewById(R.id.TipInput);

        tip.setText(String.valueOf(tipslider.getProgress()));

        tipslider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tip.setText(String.valueOf(i));
                tipChanged(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void guestsChanged(int i){
        ud.setGuests(i);
        update();
    }

    public void tipChanged(int i){
        ud.setTipPercentage((double) i);
        update();
    }

    public void update(){
        // TODO update all fields with values in UserData (ud)
    }
}
