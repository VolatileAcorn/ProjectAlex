package com.palex.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.palex.item.Item;
import com.palex.item.ItemFactory;
import com.palex.item.WeaponItem;

public class TheGame extends Game {
	SpriteBatch batch;
	Texture img;
	ItemFactory itemFactory;

	BattleScreen battleScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		battleScreen = new BattleScreen(this);
		itemFactory = new ItemFactory();


		initTests();
		makeInitialResources();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	public void initTests() {
		setScreen(battleScreen);
		Agent agent1 = new Agent("Tom B", "He were a nice hahahha, he were a nice.. shaun bean away...");
		//WeaponItem wItem1 = new WeaponItem("Hammer of doom","Incredibly tough",);
		//System.out.println(wItem1.getType());
	}

	public void makeInitialResources() {
		//make loads of resources here
		itemFactory.createAndAddResource("Bones","too creepy four me");
		itemFactory.createAndAddResource("Oak Logs","a sturdy building material");
		itemFactory.createAndAddResource("Weeds","for ugly gardens");
		//save to file
		itemFactory.storeResources();
	}

}
