package com.palex.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * Created by Tom on 25/11/2015.
 */
public class BattleScreen implements Screen{

    TheGame game;

    //constructor keeps reference to game class
    public BattleScreen(TheGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        //when set to this screen
    }

    @Override
    public void hide() {
        //when changed from this screen to another
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        //never called automatically
    }
}
