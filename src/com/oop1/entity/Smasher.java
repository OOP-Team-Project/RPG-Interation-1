package com.oop1.entity;

public class Smasher extends Occupation {

    public Smasher() { }

    public void performAbility() {
        System.out.println("Hi I'm Smasher");
    }

    @Override
    public int getBaseStrength() {
        return 25;
    }

    @Override
    public int getStrengthIncrement() {
        return 4;
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
        return 15;
    }

    @Override
    public double getMovementSpeed() {
        return 2.5;
    }

    @Override
    public int getBaseHardiness() {
        return 30;
    }

    public String toString() {
        return "Smasher";
    }

    public String printOccupation(){
        return "SMASHER";
    }
}
