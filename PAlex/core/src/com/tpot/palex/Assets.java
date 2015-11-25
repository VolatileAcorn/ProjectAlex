package com.tpot.palex;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.awt.*;

/**
 * Created by Tom on 13/11/2015.
 */
public class Assets {

    public static Texture menu_texture;
    public static Sprite menu_sprite;

    public static void load(){
        menu_texture = new Texture(Gdx.files.local("Splash_Screen.png"));
        menu_texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        menu_sprite = new Sprite(menu_texture);
        menu_sprite.flip(false, true);
    }

}
