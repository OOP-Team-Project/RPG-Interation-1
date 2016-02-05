package com.oop1.entity;

public class Smasher extends Occupation {

    public Smasher() {
        baseStrength = 25;
        strengthIncrement = 4;
        baseAgility = 20;
        agilityIncrement = 3;
        baseIntellect = 15;
        intellectBase = 2;
        movementSpeed = 2.5;
    }

    public void performAbility() {
        System.out.println("Hi I'm Smasher");
    }

    @Override
    public int getBaseHardiness() {
        return 30;
    }
}