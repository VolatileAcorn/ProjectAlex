package com.palex.game;

import com.palex.item.WeaponItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 08/12/2015.
 */
public class SkillFactory {

    private List<Skill> skillList;
    private static final int SKILL_LIST_SIZE = 500;

    private Skill nullSkill = null;

    public SkillFactory () {
        this.skillList = new ArrayList<Skill>(SKILL_LIST_SIZE);
    }

    public Skill getSkill(int skillID) {
        if (skillID < 0 || skillID > SKILL_LIST_SIZE){
            return nullSkill;
        }
        return skillList.get(skillID);
    }

}
