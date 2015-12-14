package com.palex.item;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.palex.game.Agent;
import com.palex.game.Skill;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.palex.item.Item.ItemType;

/**
 * Created by Tom on 05/12/2015.
 */
public class ItemFactory {


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

    private Item noItem = null;

    private Map<Integer, WeaponItem> weaponMap;
    private Map<Integer, ResourceItem> resourceMap;
    private Map<Integer, ArmourSetItem> armourSetMap;
    private Map<Integer, CharmItem> charmMap;

    //number of the next itemID in the relevant maps
    private int weaponNextID;
    private int armourSetNextID;
    private int resourceNextID;
    private int charmNextID;

    //File handlers for tsv
    //format = name "\t" description "\t" itemID "\n"   (minus spaces in between)
    private FileHandle resourceItemFile = Gdx.files.local("resourceItems.tsv");



    public ItemFactory() {
        initItemMaps();
        loadResources();
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

        else if (itemID > MAX_ARMOURSET_ITEM_ID && itemID <= MAX_CHARM_ITEM_ID && this.charmMap.containsKey(itemID)) {
            return this.charmMap.get(itemID);
        }

        return noItem;
    }

    public void deleteItem (int itemID) {
        if (itemID > 0 && itemID <= MAX_RESOURCE_ITEM_ID && this.resourceMap.containsKey(itemID)) {
            this.resourceMap.remove(itemID);
        }

        else if (itemID > MAX_RESOURCE_ITEM_ID && itemID <= MAX_WEAPON_ITEM_ID && this.weaponMap.containsKey(itemID)) {
            this.weaponMap.remove(itemID);
        }

        else if (itemID > MAX_WEAPON_ITEM_ID && itemID <= MAX_ARMOURSET_ITEM_ID && this.armourSetMap.containsKey(itemID)) {
            this.armourSetMap.remove(itemID);
        }

        else if (itemID > MAX_ARMOURSET_ITEM_ID && itemID <= MAX_CHARM_ITEM_ID && this.charmMap.containsKey(itemID)) {
            this.charmMap.remove(itemID);
        }
    }

    public int generateItem (Agent player, Agent enemy, Item.ItemType itemType) {

        switch (itemType) {
            case RESOURCE: {
                //give a predefined resource ID
            }
            case WEAPON: {
                //generate weapon based on some tables and add to list
                WeaponItem tempWeapon = new WeaponItem("TestName","TestDescription",weaponNextID, new int[0], WeaponItem.WeaponStyle.MAGIC, WeaponItem.WeaponType.ONEHAND, WeaponItem.WeaponElement.EARTH, 0);
                weaponMap.put(weaponNextID, tempWeapon);
                weaponNextID++;
            }
            case ARMOURSET: {
                //generate armour set based on some tables and add to list

            }
            case CHARM: {
                //generate charm based on some tables and add to list

            }
        }

        return 0;
    }

    private void loadResources() {
        String[] currentResource;
        String[] resourceItemArray  = resourceItemFile.readString().split("\n");
        ResourceItem tempResource;

        for (int i = 0; i < resourceItemArray.length; i++) {
            currentResource = resourceItemArray[i].split("\t");
            try {
                if (currentResource.length != 3) {throw new Exception("Error reading resource: " + currentResource.toString());}
            } catch (Exception e) {
                e.printStackTrace();
            }

            tempResource = new ResourceItem(currentResource[0],currentResource[1], ItemType.RESOURCE ,Integer.parseInt(currentResource[2]));
            resourceMap.put(tempResource.getItemID(),tempResource);
            if (tempResource.getItemID() >= resourceNextID) {
                resourceNextID = tempResource.getItemID() + 1;
            }
        }
    }

    /**
     * maybe a redundant method, just used for testing.
     */
    public void createAndAddResource(String name, String description) {
        ResourceItem newResource = new ResourceItem(name,description,ItemType.RESOURCE,resourceNextID);
        resourceMap.put(resourceNextID,newResource);
        resourceNextID ++;
    }

    /**
     * maybe a redundant method, just used for testing.
     */
    public void storeResources() {
        ArrayList<ResourceItem> resourceItems = new ArrayList<ResourceItem>(resourceMap.values());
        String resourceItemsAsString = "";
        for (int i = 0; i < resourceItems.size(); i++) {
            resourceItemsAsString += resourceItems.get(i).getName().toString() + "\t";
            resourceItemsAsString += resourceItems.get(i).getDescription().toString() + "\t";
            resourceItemsAsString += String.valueOf(resourceItems.get(i).getItemID()) + "\n";
        }
        resourceItemFile.writeString(resourceItemsAsString,false);
    }

}
