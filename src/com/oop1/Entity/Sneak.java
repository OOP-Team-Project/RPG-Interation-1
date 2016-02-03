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

    public void PerformAbility() {
        System.out.println("Hi I'm Sneak");
    }
}