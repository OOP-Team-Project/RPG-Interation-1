package com.oop1.entity;

public class Sneak extends Occupation {

    public Sneak() {
        // constructor doesn't need any parameters
//        baseStrength = 20;
//        strengthIncrement = 3;
//        baseAgility = 25;
//        agilityIncrement = 4;
//        baseIntellect = 15;
//        intellectBase = 2;
//        movementSpeed = 3;
//        baseHardiness = 15;
    }


    public void performAbility() {
        System.out.println("Hi I'm Sneak");
    }

    @Override
    protected int getBaseStrength() {
        return 20;
    }

    @Override
    protected int getStrengthIncrement() {
        return 3;
    }

    @Override
    protected int getBaseAgility() {
        return 25;
    }

    @Override
    protected int getAgilityIncrement() {
        return 4;
    }

    @Override
    protected int getBaseIntellect() {
        return 15;
    }

    @Override
    protected int getIntellectIncrement() {
        return 5;
    }

    @Override
    protected double getMovementSpeed() {
        return 3;
    }

    @Override
    public int getBaseHardiness() {
        return 15;
    }


    public String toString() {
        return "Sneak";
	}

    @Override
    public String printOccupation(){
        return "SNEAK";
    }
}
