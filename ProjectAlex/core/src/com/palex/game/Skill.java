package com.palex.game;

import com.palex.item.WeaponItem;

/**
 * Created by Tom on 30/11/2015.
 */
public class Skill {

    private String skillName;
    private String skillDescription;
    private WeaponItem.WeaponStyle weaponStyleRestriction;
    private WeaponItem.WeaponType weaponTypeRestriction;
    private int levelRestriction;
    private SkillType skillType;
    private int power;

    public Skill(String skillName ,String skillDescription ,WeaponItem.WeaponStyle weaponStyleRestriction, WeaponItem.WeaponType weaponTypeRestriction, int levelRestriction, SkillType skillType, int power) {
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.weaponStyleRestriction = weaponStyleRestriction;
        this.weaponTypeRestriction = weaponTypeRestriction;
        this.levelRestriction = levelRestriction;
        this.skillType = skillType;
        this.power = power;
    }

    public WeaponItem.WeaponStyle getWeaponStyleRestriction() {
        return weaponStyleRestriction;
    }

    public WeaponItem.WeaponType getWeaponTypeRestriction() {
        return weaponTypeRestriction;
    }

    public int getLevelRestriction() {
        return levelRestriction;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public int getPower() {
        return power;
    }

    public enum SkillType {
        ONE_HIT, COMBO, DRAIN, HEAL, STATUS, ULTIMATE
    }
}
