package com.tpot.palex;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AlexGame extends Game {

	public GameScreen game_screen;

	@Override
	public void create(){

		Assets.load();

		game_screen = new GameScreen(this);

		setScreen(game_screen);
	}

}
