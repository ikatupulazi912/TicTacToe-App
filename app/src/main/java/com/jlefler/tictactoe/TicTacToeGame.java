package com.jlefler.tictactoe;

public class TicTacToeGame
{
    public static final int ROWS = 3;
    public static final int COLS = 3;

    private boolean[][] mSpaces;

    public TicTacToeGame()
    {
        mSpaces = new boolean[ROWS][COLS];
    }

    public void selectSpace(int row, int col)
    {
        for (int r = 0; row < TicTacToeGame.ROWS; r++)
        {
            for (int c = 0; col < TicTacToeGame.COLS; c++)
            {

            }
        }
    }
}
