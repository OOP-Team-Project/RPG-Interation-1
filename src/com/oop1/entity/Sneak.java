package com.oop1.entity;

public class Sneak extends Occupation {

    public Sneak() {
        baseStrength = 20;
        strengthIncrement = 3;
        baseAgility = 25;
        agilityIncrement = 4;
        baseIntellect = 15;
        intellectBase = 2;
        movementSpeed = 3;
    }

    public void performAbility() {
        System.out.println("Hi I'm Sneak");
    }

    @Override
    public int getBaseHardiness() {
        return 15;
    }
}