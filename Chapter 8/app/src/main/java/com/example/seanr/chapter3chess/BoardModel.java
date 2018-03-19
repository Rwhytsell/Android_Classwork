package com.example.seanr.chapter3chess;

/**
 * Created by team 1 on 1/29/2018.
 */
public class BoardModel
{
    private ChessPiece[][] board;

    /**
     * Instantiates a new Board model.
     */
    public BoardModel()
    {
        board = new ChessPiece[8][8];
    }

    /**
     * The startGame method starts a new game
     * by instantiating a new chess piece for
     * all the pieces.
     */
    public void startGame()
    {
        Pawn whitePawn = new Pawn();
        Pawn blackPawn = new Pawn();
        Rook whiteRook = new Rook();
        Rook blackRook = new Rook();
        Knight whiteKnight = new Knight();
        Knight blackKnight = new Knight();
        Bishop whiteBishop = new Bishop();
        Bishop blackBishop = new Bishop();
        Queen whiteQueen = new Queen();
        Queen blackQueen = new Queen();
        King whiteKing = new King();
        King blackKing = new King();
        ChessPiece blank = new ChessPiece();
        blank.setName("EPT");

        for(int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                board[row][col] = blank;
                if (row == 1 || row == 6)
                {
                    if(row == 1)
                    {
                        whitePawn.setName("WP");
                        board[row][col] = whitePawn;
                    }
                    else
                    {
                        blackPawn.setName("BP");
                        board[row][col] = blackPawn;
                    }
                }
                else if ( row == 0 || row == 7)
                {
                    if (col == 0 || col == 7)
                    {
                        if(row == 0)
                        {
                            whiteRook.setName("WR");
                            board[row][col] = whiteRook;
                        }
                        else
                        {
                            blackRook.setName("BR");
                            board[row][col] = blackRook;
                        }
                    }
                    else if (col == 1 || col == 6)
                    {
                        if(row == 0 )
                        {
                            whiteKnight.setName("WK");
                            board[row][col] = whiteKnight;
                        }
                        else
                        {
                            blackKnight.setName("BK");
                            board[row][col] = blackKnight;
                        }
                    }
                    else if (col == 2 || col == 5)
                    {
                        if(row == 0 )
                        {
                            whiteBishop.setName("WB");

                            board[row][col] = whiteBishop;
                        }
                        else
                        {
                            blackBishop.setName("BB");

                            board[row][col] = blackBishop;
                        }
                    }
                    else if (col == 3)
                    {
                        if(row == 0 )
                        {
                            whiteQueen.setName("WQ");
                            board[row][col] = whiteQueen;
                        }
                        else
                        {
                            blackQueen.setName("BQ");
                            board[row][col] = blackQueen;
                        }
                    }
                    else
                    {
                        if(row == 0 )
                        {
                            whiteKing.setName("WKG");
                            board[row][col] = whiteKing;
                        }
                        else
                        {
                            blackKing.setName("BKG");
                            board[row][col] = blackKing;
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets piece.
     *
     * @param row the row
     * @param col the col
     * @return the piece
     */
    public ChessPiece getPiece(int row, int col) {return board[row][col];}

    public void movePiece(int[] src, int[] dest)
    {
        ChessPiece blank = new ChessPiece();
        blank.setName("EPT");
        ChessPiece temp = board[src[0]][src[1]];
        board[dest[0]][dest[1]] = temp;
        board[src[0]][src[1]] = blank;
    }
}
