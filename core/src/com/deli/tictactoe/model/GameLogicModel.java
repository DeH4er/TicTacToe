package com.deli.tictactoe.model;

/**
 * Created by denys on 29.04.17.
 */
public class GameLogicModel {
    private GameState state;
    private Player[][] board;
    private Player shouldMove;

    public GameLogicModel() {
        board = new Player[3][3];
        GameState state = GameState.GAME_ON;
        shouldMove = Player.PLAYER_1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Player.NULL;
            }
        }
    }

    public void move(Player playerMove, int cellPositionX, int cellPositionY) {
        if (shouldMove == playerMove) {
            if (board[cellPositionX][cellPositionY] == Player.NULL) {
                board[cellPositionX][cellPositionY] = shouldMove;
                getNextPlayer();
            }
        }
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
}
