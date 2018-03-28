package com.example.ethan.chapter9;

import android.app.Fragment;
import java.util.Random;

/**
 * The type Random num fragment.
 */
public class RandomNumFragment extends Fragment
{
    /**
     * Instantiates a new Random num fragment.
     */
    public RandomNumFragment()
    {

    }

    /**
     * The Rand num.
     */
    Random randNum = new Random(System.currentTimeMillis());

    /**
     * Gets num.
     *
     * @return the num
     */
    public int getNum()
    {
        return randNum.nextInt(100) + 1;
    }
}
