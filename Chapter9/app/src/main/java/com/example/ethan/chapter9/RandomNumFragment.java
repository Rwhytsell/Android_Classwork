package com.example.ethan.chapter9;

import android.app.Fragment;
import java.util.Random;

public class RandomNumFragment extends Fragment
{
    public RandomNumFragment()
    {

    }

    Random randNum = new Random(System.currentTimeMillis());

    public int getNum()
    {
        return randNum.nextInt(100) + 1;
    }
}
