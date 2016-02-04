package com.oop1.entity;

import com.oop1.engine.Rules;

/**
 * Holds an Entity's statistics.
 *
 * Stats objects should be created via the StatsBuilder as in:
 * <pre>
 *      Stats.builder()
 *           .occupation(foo)
 *           .agility(5)
 *           ...
 *           .build();
 * </pre>
 *
 * To create the base stats for a new character, all one needs to supply is
 * the occupation: <pre>Stats.builder().occupation(foo).build()</pre>
 */
public class Stats {

    static final int LIFE_PER_STRENGTH = 25;
    static final int OFFENSIVE_RATING_PER_STRENGTH = 1;
    static final int MANA_PER_INTELLECT = 20;
    static final double DEFENSIVE_RATING_PER_AGILITY = 0.002;
    static final double ARMOR_RATING_PER_HARDINESS = 0.5;

    public static StatsBuilder builder() {
        return new StatsBuilder();
    }

    private int experience;
    private int currentLife;
    private int currentMana;

    // primary stats
    private int strength;
    private int agility;
    private int intellect;
    private int hardiness;
    private double movementSpeed;

    private Occupation occupation;

    /**
     * only allow construction of Stats via the StatsBuilder.
     */
    protected Stats() {
    }

    public int getMaxMana() {
        return intellect * MANA_PER_INTELLECT;
    }

    public int getMaxLife() {
        return strength * LIFE_PER_STRENGTH;
    }

    public int getCurrentLevel() {
        return Rules.getLevelFromTotalExperience(experience);
    }

    public double getOffensiveRating() {
        return strength * OFFENSIVE_RATING_PER_STRENGTH;
    }

    public double getDefensiveRating() {
        return agility * DEFENSIVE_RATING_PER_AGILITY;
    }

    public double getArmorRating() {
        return hardiness * ARMOR_RATING_PER_HARDINESS;
    }

    /**
     * Immediately gives this Entity enough experience to move to the next level.
     */
    public void immediatelyGainLevel() {
        gainExperience(Rules.getExperienceRequiredForLevel(getCurrentLevel() + 1) - experience);
    }

    private void didGainLevel() {
        strength += occupation.getStrengthIncrement();
        agility += occupation.getAgilityIncrement();
        intellect += occupation.getIntellectIncrement();

        currentLife = getMaxLife();
        currentMana = getMaxMana();
    }

    /**
     * Give this character a given amount of experience. If this experience causes the character to level up,
     * increases their stats appropriately and resets their current life and mana pools.
     *
     * @param amount the amount of experience to gain; must be a positive integer
     */
    public void gainExperience(int amount) {

        if (amount < 0) {
            throw new RuntimeException("Tried to gain a negative amount of experience.");
        }

        int previousLevel = getCurrentLevel();
        experience += amount;
        int newLevel = getCurrentLevel();

        if (previousLevel < newLevel) {
            didGainLevel();
        }

    }

    public void takeDamage(int amount) {
        currentLife -= amount;
        if (currentLife < 0) {
            currentLife = 0;
        }
    }

    public void healDamage(int amount) {
        currentLife += amount;
        if (currentLife > getMaxLife()) {
            currentLife = getMaxLife();
        }
    }

    public boolean isDead() {
        return currentLife <= 0;
    }

    public void expendMana(int amount) {
        currentMana -= amount;
        if (currentMana < 0) {
            currentMana = 0;
        }
    }

    public void gainMana(int amount) {
        currentMana += amount;
        if (currentMana > getMaxMana()) {
            currentMana = getMaxMana();
        }
    }

    public int getExperience() {
        return experience;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getHardiness() {
        return hardiness;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public static class StatsBuilder {
        private int agility;
        private int strength;
        private int intellect;
        private int hardiness;
        private double movementSpeed = Double.NEGATIVE_INFINITY;

        private int experience = Integer.MIN_VALUE;
        private int currentLife = Integer.MIN_VALUE;
        private int currentMana = Integer.MIN_VALUE;

        private Occupation occupation;

        public Stats build() {
            if (occupation == null) {
                throw new RuntimeException("A Stats must have an occupation");
            }
            Stats stats = new Stats();
            stats.occupation = occupation;

            // if a value wasn't provided for a property, use the default
            stats.agility = agility == Integer.MIN_VALUE ? occupation.getBaseAgility() : agility;
            stats.strength = strength == Integer.MIN_VALUE ? occupation.getBaseStrength() : strength;
            stats.intellect = intellect == Integer.MIN_VALUE ? occupation.getBaseIntellect() : intellect;
            stats.hardiness = hardiness == Integer.MIN_VALUE ? occupation.getBaseHardiness() : hardiness;
            stats.experience = experience == Integer.MIN_VALUE ? 0 : experience;
            stats.currentLife = currentLife == Integer.MIN_VALUE ? stats.getMaxLife() : currentLife;
            stats.currentMana = currentMana == Integer.MIN_VALUE ? stats.getMaxMana() : currentMana;
            stats.movementSpeed = movementSpeed == Double.NEGATIVE_INFINITY ? stats.movementSpeed : movementSpeed;
            return stats;
        }

        public StatsBuilder agility(int agility) {
            this.agility = agility;
            return this;
        }

        public StatsBuilder strength(int strength) {
            this.strength = strength;
            return this;
        }

        public StatsBuilder intellect(int intellect) {
            this.intellect = intellect;
            return this;
        }

        public StatsBuilder hardiness(int hardiness) {
            this.hardiness = hardiness;
            return this;
        }

        public StatsBuilder experience(int experience) {
            this.experience = experience;
            return this;
        }

        public StatsBuilder currentLife(int currentLife) {
            this.currentLife = currentLife;
            return this;
        }

        public StatsBuilder currentMana(int currentMana) {
            this.currentMana = currentMana;
            return this;
        }

        public StatsBuilder movementSpeed(double movementSpeed) {
            this.movementSpeed = movementSpeed;
            return this;
        }

        public StatsBuilder occupation(Occupation occupation) {
            this.occupation = occupation;
            return this;
        }
    }

}
