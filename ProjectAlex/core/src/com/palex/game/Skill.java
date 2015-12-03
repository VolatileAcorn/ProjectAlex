package com.palex.game;

import com.palex.item.WeaponItem;

/**
 * Created by Tom on 30/11/2015.
 */
public class Skill {

    private WeaponItem.WeaponStyle weaponStyleRestriction;
    private WeaponItem.WeaponType weaponTypeRestriction;
    private int levelRestriction;
    private SkillType skillType;
    private int power;

    public Skill(WeaponItem.WeaponStyle weaponStyleRestriction, WeaponItem.WeaponType weaponTypeRestriction, int levelRestriction, SkillType skillType, int power) {
        this.weaponStyleRestriction = weaponStyleRestriction;
        this.weaponTypeRestriction = weaponTypeRestriction;
        this.levelRestriction = levelRestriction;
        this.skillType = skillType;
        this.power = power;
    }

    public enum SkillType {
        ONE_HIT, COMBO, HEAL, DRAIN, ULTIMATE
    }
}
