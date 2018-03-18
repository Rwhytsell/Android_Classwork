package com.example.seanr.chapter3chess;

import android.graphics.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity
{
    private BoardView mBoardView;
    private BoardModel mBoardModel;
    private boolean holding = false;
    private ChessPiece held;
    private int[] heldLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBoardModel = new BoardModel();
        mBoardModel.startGame();

        ButtonHandler bh = new ButtonHandler();

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int w = size.x / 8;
        mBoardView = new BoardView(this, w, bh);
        update();
       setContentView(mBoardView);
    }

    private void update()
    {
        for(int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                if(mBoardModel.getPiece(row, col) != null)
                {
                    switch (mBoardModel.getPiece(row,col).getName())
                    {
                        case "WP": mBoardView.getSquare(row, col).setImageResource(R.drawable.wpawn);
                            break;
                        case "BP": mBoardView.getSquare(row, col).setImageResource(R.drawable.bpawn);
                            break;
                        case "WR": mBoardView.getSquare(row, col).setImageResource(R.drawable.wrook);
                            break;
                        case "BR": mBoardView.getSquare(row, col).setImageResource(R.drawable.brook);
                            break;
                        case "WK": mBoardView.getSquare(row, col).setImageResource(R.drawable.wknight);
                            break;
                        case "BK": mBoardView.getSquare(row, col).setImageResource(R.drawable.bknight);
                            break;
                        case "WB": mBoardView.getSquare(row, col).setImageResource(R.drawable.wbishop);
                            break;
                        case "BB": mBoardView.getSquare(row, col).setImageResource(R.drawable.bbishop);
                            break;
                        case "WQ": mBoardView.getSquare(row, col).setImageResource(R.drawable.wqueen);
                            break;
                        case "BQ": mBoardView.getSquare(row, col).setImageResource(R.drawable.bqueen);
                            break;
                        case "WKG": mBoardView.getSquare(row, col).setImageResource(R.drawable.wking);
                            break;
                        case "BKG": mBoardView.getSquare(row, col).setImageResource(R.drawable.bking);
                            break;
                    }
                }
            }
        }
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            int[] coords = mBoardView.getSquareCoordinates(v);
            ChessPiece piece = mBoardModel.getPiece(coords[0], coords[1]);
            Log.i("Debug", "x: " + coords[0] + " y: " + coords[1]);
            Log.i("Debug", "Piece: " + piece.getName());
            {
                if (!holding) {
                    if (piece.getName() != "EPT") {
                        holding = true;
                        held = piece;
                        heldLocation = coords;
                    }
                } else {
                    if (piece.getName() == "EPT") {
                        holding = false;
                        mBoardModel.movePiece(heldLocation, coords);
                    }
                }
            }
            update();
        }
    }
}
