package com.tpot.palex.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tpot.palex.AlexGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "AlexGame";
		config.width = 1280;
		config.height = 720;

		new LwjglApplication(new AlexGame(), config);
	}
}
