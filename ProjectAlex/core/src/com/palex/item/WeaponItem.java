package com.palex.item;

import com.palex.game.Skill;
import com.palex.item.Item;

import java.util.Arrays;

/**
 * Created by Tom on 30/11/2015.
 */
public class WeaponItem extends Item {

    private int[] skills;
    private WeaponStyle weaponStyle; //ranged melee etc
    private WeaponType weaponType; //2h or 1h
    private WeaponElement weaponElement; //earth, water etc
    private int basePower; //base power


    public WeaponItem(String name, String description, int weaponItemID, int[] skills, WeaponStyle weaponStyle, WeaponType weaponType, WeaponElement weaponElement, int basePower) {
        super(name, description, ItemType.WEAPON, weaponItemID);
        this.skills = skills;
        this.weaponStyle = weaponStyle;
        this.weaponType = weaponType;
        this.weaponElement = weaponElement;
        this.basePower = basePower;
    }


    public enum WeaponStyle {
        RANGED, MELEE, MAGIC
    }

    public enum WeaponType {
        ONEHAND, TWOHAND
    }

    public enum WeaponElement {
        EARTH, WATER, FIRE, NORMAL
    }
}
