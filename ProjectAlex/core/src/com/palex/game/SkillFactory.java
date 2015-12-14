package com.palex.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.palex.item.WeaponItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 08/12/2015.
 */
public class SkillFactory {

    private List<Skill> skillList;
    private static final int SKILL_LIST_SIZE = 500;

    //Format: name \t description \t weaponStyleRest \t weaponTypeRest \t levelRest \t skillType \t power \t skillID \n
    private FileHandle skillListFile = Gdx.files.local("skillList.tsv");

    private Skill nullSkill = null;

    public SkillFactory () {
        this.skillList = new ArrayList<Skill>(SKILL_LIST_SIZE);
        loadSkills();
    }

    public Skill getSkill(int skillID) {
        if (skillID < 0 || skillID > SKILL_LIST_SIZE){
            return nullSkill;
        }
        return skillList.get(skillID);
    }

    public void loadSkills() {
        String[] currentSkill;
        String[] SkillArray  = skillListFile.readString().split("\n");
        Skill tempSkill;
        WeaponItem.WeaponStyle currentWepStyle = null;
        WeaponItem.WeaponType currentWepType = null;
        Skill.SkillType currentSkillType = null;
        System.out.println(SkillArray.length);

        for (int i = 0; i < SkillArray.length; i++) {
            currentSkill = SkillArray[i].split("\t");
            System.out.println(currentSkill.length);
            try {
                if (currentSkill.length != 8) {throw new Exception("Error reading skill: " + currentSkill.toString());}
            } catch (Exception e) {
                e.printStackTrace();
            }

            //get weaponStyleRestriction
            switch(Integer.parseInt(currentSkill[2])) {
                case 0: currentWepStyle = WeaponItem.WeaponStyle.RANGED;
                    break;
                case 1: currentWepStyle = WeaponItem.WeaponStyle.MELEE;
                    break;
                case 2: currentWepStyle = WeaponItem.WeaponStyle.MAGIC;
                    break;
            }
            //get weaponTypeRestriction
            switch(Integer.parseInt(currentSkill[3])) {
                case 0: currentWepType = WeaponItem.WeaponType.ONEHAND;
                    break;
                case 1: currentWepType = WeaponItem.WeaponType.TWOHAND;
                    break;
            }
            //get skillType
            switch(Integer.parseInt(currentSkill[5])) {
                case 0: currentSkillType = Skill.SkillType.ONE_HIT;
                    break;
                case 1: currentSkillType = Skill.SkillType.COMBO;
                    break;
                case 2: currentSkillType = Skill.SkillType.DRAIN;
                    break;
                case 3: currentSkillType = Skill.SkillType.HEAL;
                    break;
                case 4: currentSkillType = Skill.SkillType.STATUS;
                    break;
                case 5: currentSkillType = Skill.SkillType.ULTIMATE;
                    break;
            }

            tempSkill = new Skill(currentSkill[0],currentSkill[1],currentWepStyle,currentWepType,Integer.parseInt(currentSkill[4]),currentSkillType,Integer.parseInt(currentSkill[6]),Integer.parseInt(currentSkill[7]));
            skillList.add(tempSkill.getSkillID(), tempSkill);
        }
    }

}
