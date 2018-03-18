package com.example.seanr.chapter3chess;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;


/**
 * Created by Team 1 on 1/26/2018.
 */
public class BoardView extends GridLayout
{
    private ImageView[][] squares;

    /**
     * Instantiates a new Board view.
     *
     * @param context the context
     * @param width   the width
     */
    public BoardView(Context context, int width, View.OnClickListener listener)
    {
        super(context);
        setColumnCount(8);
        setRowCount(8);

        squares = new ImageView[8][8];

        for(int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                squares[row][col] = new ImageView(context);
                squares[row][col].setOnClickListener(listener);
                if( (row + col) % 2 == 0)
                {
                    squares[row][col].setBackgroundColor(Color.LTGRAY);

                }
                else
                {
                    squares[row][col].setBackgroundColor(Color.DKGRAY);

                }
                addView(squares[row][col], width, width);
            }
        }
    }

    /**
     * Gets square to set background image.
     *
     * @param row the row
     * @param col the col
     * @return the square
     */
    public ImageView getSquare(int row, int col)
    {
        return squares[row][col];
    }

    public int[] getSquareCoordinates(View v)
    {
        int x = 0;
        int y = 0;
        int[] result = new int[2];
        outerloop:
            for (ImageView[] row:  squares){
                for (ImageView col: row){
                    if(col == v)
                    {
                        result[1] = x;
                        result[0] = y;
                        break outerloop;
                    }
                    x++;
                }
                x = 0;
                y++;
            }
        return result;
    }
}