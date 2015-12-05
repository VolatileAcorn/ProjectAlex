package com.palex.game;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.util.*;

/**
 * Created by Tom on 25/11/2015.
 */
public class Agent {

    private String name;
    private String description;

    private Statistics statistics;
    private EquipmentSlots equipment;
    private Inventory inventory;


    public Agent(String name, String description) {
        this.name = name;
        this.description = description;
        this.statistics = new Statistics();
        this.equipment = new EquipmentSlots();
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }






}
