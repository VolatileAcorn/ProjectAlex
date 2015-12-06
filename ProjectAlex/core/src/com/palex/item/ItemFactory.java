package com.palex.item;

import com.palex.game.Skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 05/12/2015.
 */
public class ItemFactory {

    //WEAPON, ARMOURSET, CHARM, RESOURCE

    //Constants used to identify the type of an item based on its itemID
    private static final int MAX_RESOURCE_ITEM_ID = 1000;
    private static final int MAX_WEAPON_ITEM_ID = 300000;
    private static final int MAX_ARMOURSET_ITEM_ID = 600000;
    private static final int MAX_CHARM_ITEM_ID = 900000;

    //sizes of the hashable which will contain the currently in use items
    private static final int RESOURCE_MAP_SIZE = 1000;
    private static final int WEAPON_MAP_SIZE = 2000;
    private static final int ARMOURSET_MAP_SIZE = 2000;
    private static final int CHARM_MAP_SIZE = 2000;

    private Item noItem = new Item("","", Item.ItemType.NONE,0);

    private Map<Integer, WeaponItem> weaponMap;
    private Map<Integer, ResourceItem> resourceMap;
    private Map<Integer, ArmourSetItem> armourSetMap;
    private Map<Integer, CharmItem> charmMap;

    //number of the next itemID in the relevant maps
    private int weaponNextID;
    private int armourSetNextID;
    private int resourceNextID;
    private int charmNextID;



    public ItemFactory() {
        initItemMaps();
    }

    private void initItemMaps() {
        this.resourceNextID = 1;
        this.weaponNextID = MAX_RESOURCE_ITEM_ID + 1;
        this.armourSetNextID = MAX_WEAPON_ITEM_ID + 1;
        this.charmNextID = MAX_ARMOURSET_ITEM_ID + 1;

        this.weaponMap = new HashMap<Integer, WeaponItem>(WEAPON_MAP_SIZE);
        this.resourceMap = new HashMap<Integer, ResourceItem>(RESOURCE_MAP_SIZE);
        this.armourSetMap = new HashMap<Integer, ArmourSetItem>(ARMOURSET_MAP_SIZE);
        this.charmMap = new HashMap<Integer, CharmItem>(CHARM_MAP_SIZE);
    }

    public Item getItem(int itemID){
        if (itemID == 0) {return noItem; }

        else if (itemID > 0 && itemID <= MAX_RESOURCE_ITEM_ID && this.resourceMap.containsKey(itemID)) {
            return this.resourceMap.get(itemID);
        }

        else if (itemID > MAX_RESOURCE_ITEM_ID && itemID <= MAX_WEAPON_ITEM_ID && this.weaponMap.containsKey(itemID)) {
            return this.weaponMap.get(itemID);
        }

        else if (itemID > MAX_WEAPON_ITEM_ID && itemID <= MAX_ARMOURSET_ITEM_ID && this.armourSetMap.containsKey(itemID)) {
            return this.armourSetMap.get(itemID);
        }

        else if (itemID > MAX_ARMOURSET_ITEM_ID && itemID <= MAX_CHARM_ITEM_ID && this.resourceMap.containsKey(itemID)) {
            return this.charmMap.get(itemID);
        }

        return noItem;
    }

}
