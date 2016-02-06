package com.oop1.entity;

public abstract class Occupation {

    protected int baseStrength;
    protected int strengthIncrement;

    protected int baseAgility;
    protected int agilityIncrement;

    protected int baseIntellect;
    protected int intellectBase;

    protected double movementSpeed;
    protected int baseHardiness;

    public abstract void performAbility();

    public abstract String printOccupation();

    protected int getBaseStrength() {
        return baseStrength;
    }

    protected int getStrengthIncrement() {
        return strengthIncrement;
    }

    protected int getBaseAgility() {
        return baseAgility;
    }

    protected int getAgilityIncrement() {
        return agilityIncrement;
    }

    protected int getBaseIntellect() {
        return baseIntellect;
    }

    protected int getIntellectIncrement() {
        return intellectBase;
    }

    protected double getMovementSpeed() {
        return movementSpeed;
    }

    public int getBaseHardiness() {
        return baseHardiness;
    }
}