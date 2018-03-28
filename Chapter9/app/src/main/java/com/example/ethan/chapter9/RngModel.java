package com.example.ethan.chapter9;

public class RngModel
{
    int randomNumber;

    public RngModel(int randomNumber)
    {
        setRandomNumb(randomNumber);
    }

    public void setRandomNumb(int number)
    {
        randomNumber = number;
    }


    public String howClose(int guess)
    {
        if(guess >= 1 ||  guess <= 100)
        {
            if(guess == randomNumber)
            {
                return "Winner winner, Chicken Dinner! You got it!";
            }
            else if (guess >=  randomNumber)
            {
                return "Yikes, Too low!";
            }
            else if(guess <= randomNumber)
            {
                return "Too High Brother!";
            }
        }
        return "Not even close bro!";
    }
}

