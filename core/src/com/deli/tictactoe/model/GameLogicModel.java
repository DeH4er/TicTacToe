package com.deli.tictactoe.model;

/**
 * Created by denys on 29.04.17.
 */
public class GameLogicModel {
    GameState state;
    int[][] board;

    public GameLogicModel() {
        board = new int[3][3];
        GameState state = GameState.GAME_ON;
    }
}
