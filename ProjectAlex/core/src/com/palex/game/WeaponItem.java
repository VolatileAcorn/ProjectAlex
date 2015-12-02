package com.palex.game;

/**
 * Created by Tom on 30/11/2015.
 */
public class WeaponItem extends Item {

    private Skill skill;
    private WeaponStyle weaponStyle; //ranged melee etc
    private WeaponType weaponType; //2h or 1h
    private WeaponElement weaponElement; //earth, water etc
    private int basePower; //base power


    public WeaponItem(String name, String description, Skill skill, WeaponStyle weaponStyle, WeaponType weaponType, WeaponElement weaponElement, int basePower) {
        super(name, description, ItemType.WEAPON);
        this.skill = skill;
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
