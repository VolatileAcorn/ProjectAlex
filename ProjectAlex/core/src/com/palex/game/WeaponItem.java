package com.palex.game;

/**
 * Created by Tom on 30/11/2015.
 */
public class WeaponItem extends Item {

    private Skills skills;
    private int style; //ranged melee etc
    private int type; //2h or 1h
    private int element; //earth, water etc
    private int power; //base power


    public WeaponItem(String name, String description) {
        super(name, description, 1);

    }

}
