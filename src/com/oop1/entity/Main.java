package com.oop1.entity;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Occupation o = new Sneak();
        Stats s = new Stats(o);
        s.printEverything();

        Scanner sc = new Scanner(System.in);
        o.PerformAbility();
        System.out.println("------------------" +
                        "\nAvailable commands:" +
                        "\ntake damage" +
                        "\nheal damage" +
                        "\ngain exp" +
                        "\nprint everything" +
                        "\nprint commands"
        );

        while (true) {
            String command = sc.nextLine();
            switch (command) {
                case "take damage":
                    System.out.println("How much damage you want to take?");
                    s.takeDamage(sc.nextInt());
                    break;
                case "heal damage":
                    System.out.println("How much damage you want to heal?");
                    s.healDamage(sc.nextInt());
                    break;
                case "gain exp":
                    System.out.println("How many experience you want to gain?");
                    System.out.println("(Experience needed to level up is: " + s.getExp() + ")");
                    s.incExp(sc.nextDouble());
                    break;
                case "print everything":
                    s.printEverything();
                    break;
                case "print commands":
                    System.out.println("------------------" +
                                    "Available commands:" +
                                    "\ntake damage" +
                                    "\nheal damage" +
                                    "\ngain exp" +
                                    "\nprint everything" +
                                    "\nprint commands"
                    );
                default:
                    break;
            }
        }
    }
}
