package com.oop1.entity;

public class Summoner extends Occupation {

    public Summoner() {
        baseStrength = 15;
        strengthIncrement = 2;
        baseAgility = 20;
        agilityIncrement = 3;
        baseIntellect = 25;
        intellectBase = 4;
        movementSpeed = 2;
    }

    public void performAbility() {
        System.out.println("Hi I'm Summoner");
    }

    @Override
    public int getBaseHardiness() {
        return 10;
    }
}