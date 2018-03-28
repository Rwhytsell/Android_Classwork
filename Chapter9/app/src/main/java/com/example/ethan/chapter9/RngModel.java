package com.example.ethan.chapter9;

/**
 * The type Rng model.
 */
public class RngModel
{
    /**
     * The Random number.
     */
    int randomNumber;

    /**
     * Instantiates a new Rng model.
     *
     * @param randomNumber the random number
     */
    public RngModel(int randomNumber)
    {
        setRandomNumb(randomNumber);
    }

    /**
     * Sets random numb.
     *
     * @param number the number
     */
    public void setRandomNumb(int number)
    {
        randomNumber = number;
    }


    /**
     * How close string.
     *
     * @param guess the guess
     * @return the string
     */
    public String howClose(int guess)
    {
        if(guess >= 1 ||  guess <= 100)
        {
            if(guess == randomNumber)
            {
                return "Winner winner, Chicken Dinner! You got it!";
            }
            else if (guess >  randomNumber)
            {
                return "Too High Brother!";
            }
            else if(guess < randomNumber)
            {
                return "Yikes, Too low!";
            }
        }
        return "Not even close bro!";
    }
}

