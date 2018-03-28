package com.example.ethan.chapter9;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity
{

    private RandomNumFragment numb;
    private  RngModel rngFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    FragmentManager fragmentManager = getFragmentManager();


    /**
     * Play.
     *
     * @param view the view
     */
    public void play(View view)
    {

    }

}


