package com.palex.game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Tom on 25/11/2015.
 */
public class Agent {

    private String name;
    private String description;

    private Map<String,Integer> statistics;
    private Equipment  equipment;


    public Agent(String name, String description) {
        this.name = name;
        this.description = description;
        this.statistics  = new HashMap<String, Integer>();
        initStatistics();
    }

    private void initStatistics() {
        //For damage calculations
        statistics.put("FIRE_AFFINITY",0);
        statistics.put("WATER_AFFINITY",0);
        statistics.put("EARTH_AFFINITY",0);
        statistics.put("MELEE_AFFINITY",0);
        statistics.put("RANGED_AFFINITY",0);
        statistics.put("MAGIC_AFFINITY",0);

        //For resistance calculations
        statistics.put("FIRE_RESISTANCE",0);
        statistics.put("WATER_RESISTANCE",0);
        statistics.put("EARTH_RESISTANCE",0);
        statistics.put("MELEE_RESISTANCE",0);
        statistics.put("RANGED_RESISTANCE",0);
        statistics.put("MAGIC_RESISTANCE",0);

        //Determines turn order, max actions per turn and hit points
        statistics.put("SPEED",0);
        statistics.put("AGILITY",0);
        statistics.put("MAX_HP",0);
        statistics.put("CURRENT_HP",0);

    }





    private class Equipment {
    }
}
