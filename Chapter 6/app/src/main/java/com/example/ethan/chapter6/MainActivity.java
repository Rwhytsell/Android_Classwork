package com.example.ethan.chapter6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The Ud.
     */
    UserData ud = new UserData();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration config = getResources().getConfiguration();
        modifyLayout(config);


        EditText bill = findViewById(R.id.BillInput);
        bill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                Log.e("TextChange", "Changed to " + s.toString());
                if (s.length() != 0){
                    ud.setBill(Double.parseDouble(s.toString()));
                }
                else ud.setBill(0.0);

                update();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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


    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged( newConfig );
        modifyLayout(newConfig);
    }

    /**
     * Modify layout.
     *
     * @param newConfig the new config
     */
    public void modifyLayout( Configuration newConfig)
    {
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_main_landscape);}
        else if( newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);
        }
    }

    /**
     * Guests changed.
     *
     * @param i the
     */
    public void guestsChanged(int i){
        ud.setGuests(i);
        update();
    }

    /**
     * Tip changed.
     *
     * @param i the
     */
    public void tipChanged(int i){
        ud.setTipPercentage((double) i);
        update();
    }

    /**
     * Update.
     */
    public void update(){
        TextView totalTip = findViewById(R.id.TotalTipNumber);
        TextView totalBill = findViewById(R.id.TotalBillNumber);
        TextView tipPerGuest = findViewById(R.id.TipGuestNumber);
        TextView totalPerGuest = findViewById(R.id.TotalGuestNumber);
        totalTip.setText(String.format(Locale.US, "%.2f", ud.getTotalTip()));
        totalBill.setText(String.format(Locale.US, "%.2f", ud.getTotalBill()));
        tipPerGuest.setText(String.format(Locale.US, "%.2f", ud.getTipPerGuest()));
        totalPerGuest.setText(String.format(Locale.US, "%.2f", ud.getTotalPerGuest()));
    }
}
