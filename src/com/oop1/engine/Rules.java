package com.oop1.engine;

public class Rules {

    public static final double LEVEL_EXPERIENCE_EXPONENT = 1.1;
    public static final int FIRST_LEVEL_EXPERIENCE = 100;

    public static int getExperienceRequiredForLevel(int targetLevel) {
        if (targetLevel < 1) {
            throw new RuntimeException("Level must be greater than or equal to 1");
        }
        if (targetLevel == 1) { return 0; }
        return (int)(FIRST_LEVEL_EXPERIENCE * Math.pow(targetLevel, LEVEL_EXPERIENCE_EXPONENT));
    }

    public static int getLevelFromTotalExperience(int totalExperience) {
        return (int)Math.floor(Math.exp(Math.log(totalExperience / FIRST_LEVEL_EXPERIENCE) / LEVEL_EXPERIENCE_EXPONENT));
    }
}
