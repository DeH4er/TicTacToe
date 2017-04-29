package com.deli.tictactoe.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denys on 29.04.17.
 */
public class GameLogicModelTest {

    @Test
    public void moveTestPlayer1Move() {
        GameLogicModel gameLogicModel = new GameLogicModel();
        gameLogicModel.move(Player.PLAYER_1, 1, 1);
        assertEquals(Player.PLAYER_2, gameLogicModel.getShouldMove());
    }

    @Test
    public void moveTestPlayer2Move() {
        GameLogicModel gameLogicModel = new GameLogicModel();
        gameLogicModel.move(Player.PLAYER_2, 1, 1);
        assertEquals(Player.PLAYER_1, gameLogicModel.getShouldMove());
    }


    @Test
    public void moveTestDoubleMoveToOneCell() {
        GameLogicModel gameLogicModel = new GameLogicModel();
        gameLogicModel.move(Player.PLAYER_1, 1, 1);
        gameLogicModel.move(Player.PLAYER_1, 1, 1);
        assertEquals(Player.PLAYER_2, gameLogicModel.getShouldMove());
    }

    @Test
    public void player1WinsTest() {
        GameLogicModel gameLogicModel = new GameLogicModel();
        gameLogicModel.move(Player.PLAYER_1, 0, 0);
        gameLogicModel.move(Player.PLAYER_2, 1, 0);
        gameLogicModel.move(Player.PLAYER_1, 1, 1);
        gameLogicModel.move(Player.PLAYER_2, 2, 0);
        gameLogicModel.move(Player.PLAYER_1, 2, 2);
        Player[][] board = gameLogicModel.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        assertEquals(GameState.PLAYER_1_WIN, GameLogicModel.state);
    }

    @Test
    public void drawTest() {

        GameLogicModel gameLogicModel = new GameLogicModel();
        Player[][] board = gameLogicModel.getBoard();

        gameLogicModel.move(Player.PLAYER_1, 0, 0);
        gameLogicModel.move(Player.PLAYER_2, 0, 1);

        gameLogicModel.move(Player.PLAYER_1, 0, 2);
        gameLogicModel.move(Player.PLAYER_2, 1, 0);

        gameLogicModel.move(Player.PLAYER_1, 1, 1);
        gameLogicModel.move(Player.PLAYER_2, 2, 0);

        gameLogicModel.move(Player.PLAYER_1, 1, 2);
        gameLogicModel.move(Player.PLAYER_2, 2, 2);

        gameLogicModel.move(Player.PLAYER_1, 2, 1);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }

        assertEquals(GameState.DRAW, GameLogicModel.state);
    }

}