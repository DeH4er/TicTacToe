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

}