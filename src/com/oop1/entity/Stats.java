package com.oop1.entity;

public class Stats {
    // declare constants
    final int LIFE_PER_STRENGTH = 25;
    final int OFFENSIVE_RATING_PER_STRENGTH = 1;
    final int MANA_PER_INTELLECT = 20;
    final double DEFENSIVE_RATING_PER_AGILITY = 0.002;
    final double ARMOR_RATING_PER_AGILITY = 0.5;

    // about level
    private double experienceForLevelUp;
    private double experience;
    private int level;

    // current - continuously changed
    private int currentLife;
    private int currentMana;

    // primary stats
    private int strength;
    private int agility;
    private int intellect;
    private double movementSpeed;

    // derived stats
    private int maxLife;
    private int maxMana;
    private double offensiveRating;
    private double defensiveRating;
    private double armorRating;
    private Occupation occupation;

    // constructor
    public Stats(Occupation o) {
        occupation = o;
        level = 1;
        experience = 0;
        experienceForLevelUp = 100;

        strength = o.getBaseStrength();
        agility = o.getBaseAgility();
        intellect = o.getBaseIntellect();
        movementSpeed = o.getMovementSpeed();

        calculateDerivedStats();

        currentLife = maxLife;
        currentMana = maxMana;
    }

    // to be used when loading game
    protected void loadStas() {
        strength = occupation.getBaseStrength() + occupation.getStrengthIncrement() * level;
        agility = occupation.getBaseAgility() + occupation.getAgilityIncrement() * level;
        intellect = occupation.getBaseIntellect() + occupation.getIntellectIncrement() * level;
        movementSpeed = occupation.getMovementSpeed();

        calculateDerivedStats();

        currentLife = maxLife; //TODO: change to stat stored in save file
        currentMana = maxMana; //TODO: change to stat stored in save file
    }

    // below are for derived variables;
    private void calculateDerivedStats() {
        maxLife = strength * LIFE_PER_STRENGTH;
        maxMana = intellect * MANA_PER_INTELLECT;
        offensiveRating = strength * OFFENSIVE_RATING_PER_STRENGTH;
        defensiveRating = agility * DEFENSIVE_RATING_PER_AGILITY;
        armorRating = agility * ARMOR_RATING_PER_AGILITY;
    }

    // take damage
    protected void takeDamage(int damage) {
        currentLife -= damage;
        System.out.println("Current Life is: " + currentLife);

        if (currentLife <= 0) {
            die();
        }
    }

    // heal damage
    protected void healDamage(int heal) {
        if (currentLife + heal >= maxLife)
            currentLife = maxLife;
        else
            currentLife += heal;
        System.out.println("Current Life is: " + currentLife);
    }

    protected void die() {
        //TODO: delete the entity from map
        //TODO: if it's the avator, end the game
        System.out.println("Victory and defeat are both common in war.\nStand up and fight again, warrior.");
    }

    // increase Experience
    protected boolean incExp(double exp) {
        //TODO: if you step on a decal which will take you level up by 1,
        //TODO: (contd) experience will increase by (experienceForLevelUP - experience)
        experience += exp;
        while (experience >= experienceForLevelUp) {
            experience -= experienceForLevelUp;
            levelUp();
            printEverything();
        }
        return false;
    }

    // level up
    private void levelUp() {
        level += 1;
        experienceForLevelUp = 100 * Math.pow(level, 1.1);

        strength += occupation.getStrengthIncrement();
        agility += occupation.getAgilityIncrement();
        intellect += occupation.getIntellectIncrement();

        calculateDerivedStats();

        currentLife = maxLife;
        currentMana = maxMana;
    }

    protected void printEverything() {
        System.out.println(
                "level: " + level +
                        "\nexperienceForLevelUp: " + experienceForLevelUp +
                        "\nstrength: " + strength +
                        "\nagility: " + agility +
                        "\nintellect: " + intellect +
                        "\n\nmaxLife: " + maxLife +
                        "\nmaxMana: " + maxMana +
                        "\noffensiveRating: " + offensiveRating +
                        "\ndefensiveRating: " + defensiveRating +
                        "\narmorRating: " + armorRating +
                        "\n\ncurrentLife: " + currentLife +
                        "\ncurrentMana: " + currentMana +
                        "\nmovementSpeed: " + movementSpeed +
                        "\n------------------"
        );
    }

    //below only for testing
    protected double getExp() {
        return experienceForLevelUp - experience;
    }

}


    /*
    private int calculateMaxLife () {
		return strength * LIFE_PER_STRENGTH;
	}

	private int calculateMana() {
		return intellect * MANA_PER_INTELLECT;
	}

	private int calculateOffensiveRating () {
		return strength * OFFENSIVE_RATING_PER_STRENGTH;
	}

	private double calculateDefensiveRating () {
		return agility * DEFENSIVE_RATING_PER_AGILITY;
	}

	private double calculateArmorRating () {
		return agility * ARMOR_RATING_PER_AGILITY;
	}
    */







