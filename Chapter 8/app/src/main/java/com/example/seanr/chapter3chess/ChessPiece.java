package com.example.seanr.chapter3chess;

import android.provider.ContactsContract;
import android.widget.ImageView;

/**
 * Created by Team 1 on 1/29/2018.
 */
public class ChessPiece
{
    /**
     * The Name.
     */
    String name;

    /**
     * Instantiates a new Chess piece.
     */
    public ChessPiece()
    {

    }

    /**
     * Sets name.
     *
     * @param newName the new name
     */
    public void setName(String newName)
    {
        this.name = newName;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }
}
