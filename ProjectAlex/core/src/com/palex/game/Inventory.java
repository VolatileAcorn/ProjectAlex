package com.palex.game;

import java.util.Arrays;

/**
 * Created by Tom on 29/11/2015.
 */
public class Inventory {


    private static final int INVENTORY_SIZE = 20;
    private int[][] inventory;

    public Inventory() {
        this.inventory = new int[INVENTORY_SIZE][2];
        int[] tempNestedArray = {0,0};
        for (int i=0; i<inventory.length;i++){
            inventory[i] = tempNestedArray;
        }
    }

    /**
     * returns true if there is an empty position in the inventory else false
     * @return returns true if there is an empty position in the inventory else false
     */
    public boolean isNotFull() {
        return (Arrays.asList(inventory).contains(new int[] {0,0}));
    }

    /**
     * returns the index of the first empty position in the inventory, or -1 if the inventory does not contain the item
     * @return returns the index of the first empty position in the inventory, or -1 if the inventory does not contain the item
     */
    private int getFirstEmptyIndex() {
        return (Arrays.asList(inventory).indexOf(new int[]{0, 0}));
    }

    /**
     * returns the index of the specified itemID in the inventory, or -1 if the inventory does not contain the item
     * @param itemID itemID of the item you want the index of
     * @return returns the index of the specified itemID in the inventory, or -1 if the inventory does not contain the item
     */
    public int getIndexOf(int itemID) {
        for (int i = 0; i < INVENTORY_SIZE; i++) {
            if (inventory[i][0] == itemID) {return i;}
        }
        return -1;
    }

    /**
     * Adds a single item to the inventory given by its itemID, return true if successful false if there is no room
     * @param itemID itemID of the item being added
     * @return return true if successful false if there is no room
     */
    public boolean addToInventory(int itemID){
        int itemIndex = getIndexOf(itemID);
        if (itemIndex != -1) {
            inventory[itemIndex][1] += 1;
            return true;
        }
        else if (isNotFull()) {
            inventory[getFirstEmptyIndex()][0] = itemID;
            return true;
        }
        return false;
    }

    /**
     * Adds multiple items to the inventory given by an itemID, return true if successful false if there is no room
     * @param itemID itemID of the item being added
     * @param count amount of items of given itemID to be added
     * @return return true if successful false if there is no room
     */
    public boolean addToInventory(int itemID, int count) {
        int itemIndex = getIndexOf(itemID);
        if (itemIndex != -1) {
            inventory[itemIndex][1] += count;
            return true;
        }
        else if (isNotFull()) {
            inventory[getFirstEmptyIndex()] = new int[]{itemID, count};
            return true;
        }
        return false;
    }

    /**
     * removes a single item from the inventory given by an itemID, return true if successful false if the item is not in the inventory
     * @param itemID itemID of the item being removed
     * @return return true if successful false if the item is not in the inventory
     */
    public boolean removeFromInventory(int itemID){
        int itemIndex = getIndexOf(itemID);
        if (itemIndex != -1) {
            inventory[itemIndex][1] -= 1;
            if (inventory[itemIndex][1] == 0){
                inventory[itemIndex][0] = 0;
            }
            return true;
        }
        return false;
    }

    /**
     * removes multiple items from the inventory given by an itemID, return true if successful false if the item is not in the inventory or not enough of the item
     * @param itemID itemID of the item being removed
     * @param count amount of items to be removed
     * @return return true if successful false if the item is not in the inventory or not enough of the item
     */
    public boolean removeFromInventory(int itemID, int count) {
        int itemIndex = getIndexOf(itemID);
        if (itemIndex != -1) {
            if (inventory[itemIndex][1] >= count) {
                inventory[itemIndex][1] -= count;
                if (inventory[itemIndex][1] == 0){
                    inventory[itemIndex][0] = 0;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * return the itemID in a given index
     * @param index index of itemID to return
     * @return return the itemID in a given index
     */
    public int getInventoryItemID(int index){
        return inventory[index][0];
    }

    /**
     * return the count of itemID in a given index
     * @param index index of itemIDs count to return
     * @return return the count of itemID in a given index
     */
    public int getInventoryItemIDCount(int index){
        return inventory[index][1];
    }


}
