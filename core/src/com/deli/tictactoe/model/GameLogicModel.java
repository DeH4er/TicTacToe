package com.deli.tictactoe.model;

import com.deli.tictactoe.utils.Observer;
import com.deli.tictactoe.utils.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denys on 29.04.17.
 */
public class GameLogicModel implements Subject {
    
    //TODO score
    //TODO gui
    public static GameState state;
    private Player[][] board;
    private Player shouldMove;
    private List<Observer> observers;
    int freeCels;

    public GameLogicModel() {
        board = new Player[3][3];
        state = GameState.GAME_ON;
        shouldMove = Player.PLAYER_1;
        observers = new ArrayList<Observer>();
        freeCels = 8;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Player.NULL;
            }
        }
    }

    public void move(Player playerMove, int x, int y) {
        if (shouldMove == playerMove) {
            if (board[x][y] == Player.NULL) {
                board[x][y] = shouldMove;
                getNextPlayer();
                logic();
                freeCels--;
                if (state != GameState.GAME_ON) {
                    update();
                }
            }
        }
    }

    private void logic() {
        checkCols();
        checkRows();
        checkDiagonals();
    }

    private void checkCols()
    {
        if (state != GameState.GAME_ON)
            return;

        for (int i = 0; i < 3; i++)
        {
            boolean player1Win = true;
            boolean player2Win = true;
            for (int j = 0; j < 3; j++)
            {
                if (board[j][i] == Player.PLAYER_1 || board[j][i] == Player.NULL)
                {
                    player2Win = false;
                }

                if (board[j][i] == Player.PLAYER_2 || board[j][i] == Player.NULL)
                {
                    player1Win = false;
                }
            }

            if (player1Win)
            {
                state = GameState.PLAYER_1_WIN;
                return;
            } else if (player2Win)
            {
                state = GameState.PLAYER_2_WIN;
                return;
            } else if (freeCels <= 0) {
                state = GameState.DRAW;
            }

        }
    }


    private void checkRows()
    {
        if (state != GameState.GAME_ON)
            return;

        for (int i = 0; i < 3; i++)
        {
            boolean player1Win = true;
            boolean player2Win = true;
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == Player.PLAYER_1 || board[i][j] == Player.NULL)
                {
                    player2Win = false;
                }

                if (board[i][j] == Player.PLAYER_2 || board[i][j] == Player.NULL)
                {
                    player1Win = false;
                }
            }

            if (player1Win)
            {
                state = GameState.PLAYER_1_WIN;
                return;
            } else if (player2Win)
            {
                state = GameState.PLAYER_2_WIN;
                return;
            } else if (freeCels <= 0)  {
                state = GameState.DRAW;
            }

        }
    }


    private void checkDiagonals()
    {
        if (state != GameState.GAME_ON)
            return;

        boolean player1Win = true;
        boolean player2Win = true;

        for (int i = 0; i < 3; i++)
        {
            if (board[i][i] == Player.PLAYER_1 || board[i][i] == Player.NULL)
                player2Win = false;
            if (board[i][i] == Player.PLAYER_2 || board[i][i] == Player.NULL)
                player1Win = false;
        }

        if (player1Win)
        {
            state = GameState.PLAYER_1_WIN;
            return;
        } else if (player2Win)
        {
            state = GameState.PLAYER_2_WIN;
            return;
        } else if (freeCels <= 0) {
            state = GameState.DRAW;
        }


    }



    public Player[][] getBoard() {
        return board;
    }

    public Player getPlayer(int x, int y) {
        return board[x][y];
    }

    private void getNextPlayer() {
        if (shouldMove == Player.PLAYER_1) {
            shouldMove = Player.PLAYER_2;
        } else {
            shouldMove = Player.PLAYER_1;
        }
    }

    public Player getShouldMove() {
        return shouldMove;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void update() {
        for (Observer observer : observers) {
            observer.execute();
        }
    }
}
