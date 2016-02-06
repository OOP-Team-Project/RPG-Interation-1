package com.oop1.entity;

import com.oop1.entity.Stats;

/**
 * A class to represent the way in which an item modifies a player's stats
 * when equipped. All stat modifications are simple additions or subtractions
 * to the player's current stats
 */
public class StatModifier {

    private int strengthModifier;

    private int agilityModifier;

    private int intellectModifier;

    private int hardinessModifier;

    private int movementModifier;

    private int livesLeftModifier;

    public int getStrengthModifier(){
        return strengthModifier;
    }

    public int getAgilityModifier(){
        return agilityModifier;
    }

    public int getIntellectModifier(){
        return intellectModifier;
    }

    public int getHardinessModifier(){
        return hardinessModifier;
    }

    public int getMovementModifier(){
        return movementModifier;
    }

    public StatModifier(int strengthModifier,
                        int agilityModifier,
                        int intellectModifier,
                        int hardinessModifier,
                        int movementModifier,
                        int livesLeft) {
        this.strengthModifier = strengthModifier;
        this.agilityModifier = agilityModifier;
        this.intellectModifier = intellectModifier;
        this.hardinessModifier = hardinessModifier;
        this.movementModifier = movementModifier;
        this.livesLeftModifier += livesLeft;
    }

    public Stats getModifiedStats(Stats old) {
        return Stats.builder()
                    .occupation(old.getOccupation())
                    .agility(old.getAgility() + agilityModifier)
                    .strength(old.getStrength() + strengthModifier)
                    .intellect(old.getIntellect() + intellectModifier)
                    .hardiness(old.getHardiness() + hardinessModifier)
                    .movementSpeed(old.getMovementSpeed() + movementModifier)
                    .currentLife(old.getCurrentLife())
                    .currentMana(old.getCurrentMana())
                    .experience(old.getExperience())
                    .livesLeft(old.getLivesLeft() + livesLeftModifier)
                    .build();
    }
}
