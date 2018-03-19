package com.example.seanr.chapter3chess;

import android.graphics.*;
import android.media.AudioAttributes;
import android.media.SoundPool;
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
    private SoundPool.Builder spb = new SoundPool.Builder();
    private SoundPool sp = spb.build();
    int pop = 0;
    int thud = 0;
    int bad = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBoardModel = new BoardModel();
        mBoardModel.startGame();

        pop = sp.load(this, R.raw.pop, 1);
        thud = sp.load(this, R.raw.thud, 1);
        bad = sp.load(this, R.raw.bad, 1);

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
                        case "EPT": mBoardView.getSquare(row, col).setImageDrawable(null);
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
                        sp.play(pop,0.99f, 0.99f, 1, 0, 1.08844f);
                    }
                } else {
                    if (piece.getName() == "EPT") {
                        holding = false;
                        mBoardModel.movePiece(heldLocation, coords);
                        sp.play(thud,0.99f, 0.99f, 1, 0, 1.08844f);
                    } else {
                        sp.play(bad,0.99f, 0.99f, 1, 0, 1.08844f);
                    }
                }
            }
            update();
        }
    }
}
