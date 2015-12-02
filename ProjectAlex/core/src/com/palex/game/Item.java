package com.palex.game;

/**
 * Created by Tom on 30/11/2015.
 */
public class Item {

    private String name;
    private String description;
    private ItemType type;

    public Item(String name, String description, ItemType type) {
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

    public ItemType getType() {
        return type;
    }

    public enum ItemType {
        WEAPON, ARMOURSET, CHARM, RESOURCE
    }
}
