package com.palex.game;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.util.*;

/**
 * Created by Tom on 25/11/2015.
 */
public class Agent {

    private static final int INVENTORY_SIZE = 20;

    private String name;
    private String description;

    private Map<Statistics,Integer> statistics;
    private Map<EquipmentSlots,Integer> equipment;
    private List<Integer> inventory;


    public Agent(String name, String description) {
        this.name = name;
        this.description = description;
        initStatistics();
        initEquipment();
        initInventory();
    }

    private void initInventory() {
        this.inventory = new ArrayList();
        for (;inventory.size() < INVENTORY_SIZE;) {
            inventory.add(0);
        }
    }

    private void initStatistics() {
        //Stores each statistic as an integer value
        this.statistics  = new HashMap<Statistics, Integer>();
        Statistics[] all_statistics = Statistics.values();
        for (int i = 0; i < all_statistics.length; i++) {
            statistics.put(all_statistics[i],0);
        }

    }

    private void initEquipment() {
        //Stores each piece of equipment. The equipment slot name being the key and the equipment id being the value
        this.equipment  = new HashMap<EquipmentSlots, Integer>();
        EquipmentSlots[] all_equip_slots = EquipmentSlots.values();
        for (int i = 0; i < all_equip_slots.length; i++) {
            equipment.put(all_equip_slots[i],0);
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStatistics(Statistics stat) {
        //Returns the skill level / value for a given skill
        return statistics.get(stat);
    }

    public Integer getEquipment(EquipmentSlots equip_slot) {
        //Returns the equipment id of the equipment in the given equipment slot
        return equipment.get(equip_slot);
    }

    /**
     * Given the index of the item in the inventory, the itemID of the item will be returned
     * @param index the index of the item ID in the inventory
     * @return Returns the item id of the item
     */
    public Integer getInventoryItemID(int index){
        return inventory.get(index);
    }

    /**
     * Will add an item and return 1 to the inventory if there is room, otherwise it will return 0.
     * @param itemID The item ID of the item to be added to the inventory.
     * @return returns the 1 if the item has successfully been added to the inventory or 0 if there is no room.
     */
    public int addToInventory(int itemID) {
        //if there is a free inventory space
        if (inventory.contains(0)){
            inventory.add(inventory.indexOf(0), itemID);

            return 1;
        }
        return 0;
    }

    private enum Statistics {
        FIRE_AFFINITY, WATER_AFFINITY, EARTH_AFFINITY, MELEE_AFFINITY, RANGED_AFFINITY, MAGIC_AFFINITY,
        FIRE_RESISTANCE, WATER_RESISTANCE, EARTH_RESISTANCE, MELEE_RESISTANCE,RANGED_RESISTANCE, MAGIC_RESISTANCE,
        SPEED, AGILITY, MAX_HP, CURRENT_HP
    }

    private enum EquipmentSlots {
        HEAD, CHEST, LEGS, BOOTS, CAPE, NECK_ACCESSORY, HAND_ACCESSORY, MAIN_WEAPON, OFF_HAND
    }

}
