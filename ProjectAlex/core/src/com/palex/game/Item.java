package com.palex.game;

/**
 * Created by Tom on 30/11/2015.
 */
public class Item {

    private String name;
    private String description;
    private int type;

    public Item(String name, String description, int type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }
}
