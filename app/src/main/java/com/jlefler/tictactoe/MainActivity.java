package com.jlefler.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private static final String GAME_STATE = "gameState";

    private TicTacToeGame mGame;
    private Button[][] buttons;
    private int color;
    private int player1Color;
    private int player2Color;
    private String mSpaceNum;
    private Boolean playTracker = true;
    private TextView playTurn;
    private ArrayList<Integer> player1 = new ArrayList<>();
    private ArrayList<Integer> player2 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        color = ContextCompat.getColor(this, R.color.colorSpace);
        player1Color =  ContextCompat.getColor(this, R.color.playerOneSpace);
        player2Color =  ContextCompat.getColor(this, R.color.playerTwoSpace);

        playTurn = (TextView)findViewById(R.id.player_turn);

        buttons = new Button[TicTacToeGame.ROWS][TicTacToeGame.COLS];

        GridLayout gridLayout = findViewById(R.id.game_grid);
        int childIndex = 0;
        for (int row = 0; row < TicTacToeGame.ROWS; row++)
        {
            for (int col = 0; col < TicTacToeGame.COLS; col++)
            {
                buttons[row][col] = (Button) gridLayout.getChildAt(childIndex);
                childIndex++;
            }
        }
        mGame = new TicTacToeGame();


        startGame();

    }



    private void startGame()
    {
        setButtonColors();
        for (int row = 0; row < TicTacToeGame.ROWS; row++)
        {
            for (int col = 0; col < TicTacToeGame.COLS; col++)
            {
                buttons[row][col].setText(" ");
            }
        }
        playTurn.setText("Player X's Turn");
        playTracker = true;
    }

    private void setButtonColors(){
        for (int row = 0; row < TicTacToeGame.ROWS; row++)
        {
            for (int col = 0; col < TicTacToeGame.COLS; col++)
            {
                buttons[row][col].setBackgroundColor(color);
            }
        }
    }


    public void onSpaceButtonClick(View view)
    {
        String user;

        for (int row = 0; row < TicTacToeGame.ROWS; row++)
        {
                for (int col = 0; col < TicTacToeGame.COLS; col++)
                {
                    if (view == buttons[row][col])
                    {

                        if (playTurn.getText().equals("Player X Wins!") || playTurn.getText().equals("Player O Wins!") || playTurn.getText().equals("Game Tied!"))
                        {
                            Toast.makeText(this, "Game Over, Play Again.", Toast.LENGTH_SHORT).show();
                        }
                        else if (buttons[row][col].getText().equals("X") || buttons[row][col].getText().equals("O")) {
                            Toast.makeText(this, "Space Taken, Select Again.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            if (playTracker)
                            {
                                user = "X";
                                playTracker = false;
                                playTurn.setText("Player O's Turn");
                                buttons[row][col].setBackgroundColor(player1Color);
                            }
                            else
                            {

                                user = "O";
                                playTracker = true;
                                playTurn.setText("Player X's Turn");
                                buttons[row][col].setBackgroundColor(player2Color);
                            }
                            buttons[row][col].setText(user);
                        }

                        gameState(buttons);

                    }
                }
        }

    }


    public void onNewGameClick(View view)
    {
        startGame();
    }

    public void gameState(Button[][] buttons)
    {
        int count = 0;
        int taken = 0;
        player1.clear();
        player2.clear();
        for (int row = 0; row < TicTacToeGame.ROWS; row++)
        {
            for (int col = 0; col < TicTacToeGame.COLS; col++)
            {
                if (buttons[row][col].getText().equals("X"))
                {
                    player1.add(count);
                    taken++;
                } else if (buttons[row][col].getText().equals("O"))
                {
                    player2.add(count);
                    taken++;
                }
                count++;
            }
        }

        System.out.println("player One: " + player1);

        System.out.println("player Two: " + player2);

        if (player1.contains(0) && player1.contains(1) && player1.contains(2))
        {
            playTurn.setText("Player X Wins!");
        }
        else if (player2.contains(0) && player2.contains(1) && player2.contains(2))
        {
            playTurn.setText("Player O Wins!");
        }

        if (player1.contains(3) && player1.contains(4) && player1.contains(5))
        {
            playTurn.setText("Player X Wins!");
        }
        else if (player2.contains(3) && player2.contains(4) && player2.contains(5))
        {
            playTurn.setText("Player O Wins!");
        }

        if (player1.contains(6) && player1.contains(7) && player1.contains(8))
        {
            playTurn.setText("Player X Wins!");
        }
        else if (player2.contains(6) && player2.contains(7) && player2.contains(8))
        {
            playTurn.setText("Player O Wins!");
        }

        if (player1.contains(0) && player1.contains(3) && player1.contains(6))
        {
            playTurn.setText("Player X Wins!");
        }
        else if (player2.contains(0) && player2.contains(3) && player2.contains(6))
        {
            playTurn.setText("Player O Wins!");
        }

        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            playTurn.setText("Player X Wins!");
        }
        else if (player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            playTurn.setText("Player O Wins!");
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            playTurn.setText("Player X Wins!");
        }
        else if (player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            playTurn.setText("Player O Wins!");
        }

        if (player1.contains(0) && player1.contains(4) && player1.contains(8))
        {
            playTurn.setText("Player X Wins!");
        }
        else if (player2.contains(0) && player2.contains(4) && player2.contains(8)) {
            playTurn.setText("Player O Wins!");
        }

        if (player1.contains(2) && player1.contains(4) && player1.contains(6))
        {
            playTurn.setText("Player X Wins!");
        }
        else if (player2.contains(2) && player2.contains(4) && player2.contains(6))
        {
            playTurn.setText("Player O Wins!");
        }

        if (taken == 9){
            playTurn.setText("Game Tied!");
        }
    }

}
