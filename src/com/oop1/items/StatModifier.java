package com.oop1.items;

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

    public StatModifier(int strengthModifier,
                        int agilityModifier,
                        int intellectModifier,
                        int hardinessModifier,
                        int movementModifier) {
        this.strengthModifier = strengthModifier;
        this.agilityModifier = agilityModifier;
        this.intellectModifier = intellectModifier;
        this.hardinessModifier = hardinessModifier;
        this.movementModifier = movementModifier;
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
                    .build();
    }
}