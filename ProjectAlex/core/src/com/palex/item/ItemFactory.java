package com.palex.item;

import com.palex.game.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 05/12/2015.
 */
public class ItemFactory {

    //The make item function will take some paramters or the playerID and enemyID and will return the itemID for the item
    //Different lists will have different types of items stored in them
    //ItemID 0-999 = Resources, 1000-1999 = Weapons, 2000-2999 = ArmourSet etc
    //Resources are probably standard
    //Deleting makes adding so much less efficient since its harder to search for next spot


    //Could i store items using item type and itemid that way i wouldn't run out of space fullstop the list could just grow and have no collisions
    //WEAPON, ARMOURSET, CHARM, RESOURCE

    private List<WeaponItem> weaponList;
    private int weaponListPointer;
    private List<ResourceItem> resourceList;
    private int resourceListPointer;
    private List<ArmourSetItem> armourSetList;
    private int armourSetListPointer;
    private List<CharmItem> charmList;
    private int charmListPointer;

    //need to init each list in their own method with the empty item
    public ItemFactory() {
        this.weaponList = new ArrayList<WeaponItem>(800);
        this.weaponListPointer = 0;
        this.resourceList = new ArrayList<ResourceItem>(200);
        this.resourceListPointer = 0;
        this.armourSetList = new ArrayList<ArmourSetItem>(800);
        this.armourSetListPointer = 0;
        this.charmList = new ArrayList<CharmItem>(800);
        this.charmListPointer = 0;
    }


    //needs to be better, e.g random item type, element, style, power
    //need more for each item type
    //need a random generator
    public int generateWeaponItem() {
        Skill[] emptySkillList = new Skill[]{};
        WeaponItem weaponItem = new WeaponItem("GeneratedItem" + Integer.toString(weaponListPointer),"some item",weaponListPointer,emptySkillList, WeaponItem.WeaponStyle.RANGED, WeaponItem.WeaponType.ONEHAND, WeaponItem.WeaponElement.EARTH,10);
        return weaponItem.getItemID();
    }


}
