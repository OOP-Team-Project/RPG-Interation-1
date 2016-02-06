package com.oop1.entity;

public class Summoner extends Occupation {

    public Summoner() { }

    public void performAbility() {
        System.out.println("Hi I'm Summoner");
    }

    @Override
    public int getBaseStrength() {
        return 15;
    }

    @Override
    public int getStrengthIncrement() {
        return 2;
    }

    @Override
    public int getBaseAgility() {
        return 20;
    }

    @Override
    public int getAgilityIncrement() {
        return 3;
    }

    @Override
    public int getBaseIntellect() {
        return 25;
    }

    @Override
    public int getIntellectIncrement() {
        return 4;
    }

    @Override
    public double getMovementSpeed() { return 2; }

    @Override
    public int getBaseHardiness() { return 10; }

    public String toString() {
        return "Summoner";
	}

    public String printOccupation(){
        return "SUMMONER";
    }
}
