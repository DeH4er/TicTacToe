package com.deli.tictactoe.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.deli.tictactoe.TicTacToe;
import com.deli.tictactoe.screens.GameScreenManager;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameScreenManager.WIDTH;
		config.height = GameScreenManager.HEIGHT;
		new LwjglApplication(new TicTacToe(), config);
	}
}
