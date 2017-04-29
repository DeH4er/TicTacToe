package com.deli.tictactoe.model;

import com.deli.tictactoe.utils.Observer;
import com.deli.tictactoe.utils.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denys on 29.04.17.
 */
public class GameLogicModel implements Subject{
    private GameState state;
    private Player[][] board;
    private Player shouldMove;
    private List<Observer> observers;

    public GameLogicModel() {
        board = new Player[3][3];
        GameState state = GameState.GAME_ON;
        shouldMove = Player.PLAYER_1;
        observers = new ArrayList<Observer>();

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
            }
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
