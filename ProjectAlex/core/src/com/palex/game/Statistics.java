package com.palex.game;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom on 04/12/2015.
 */
public class Statistics {

    private Map<StatTypes, Integer> statistics;

    public Statistics(){
        initStatistics();
    }

    private void initStatistics() {
        this.statistics = new HashMap<StatTypes, Integer>();
        StatTypes[] all_statistics = StatTypes.values();
        for (int i = 0; i < all_statistics.length; i++) {
            statistics.put(all_statistics[i],0);
        }
    }

    public int getStatLevel(StatTypes stat) {
        return statistics.get(stat);
    }

    public void setStatLevel(StatTypes stat, int level){
        statistics.replace(stat, level);
    }

    public enum StatTypes{
        FIRE_AFFINITY, WATER_AFFINITY, EARTH_AFFINITY, MELEE_AFFINITY, RANGED_AFFINITY, MAGIC_AFFINITY,
        FIRE_RESISTANCE, WATER_RESISTANCE, EARTH_RESISTANCE, MELEE_RESISTANCE,RANGED_RESISTANCE, MAGIC_RESISTANCE,
        SPEED, AGILITY, MAX_HP, CURRENT_HP
    }
}
