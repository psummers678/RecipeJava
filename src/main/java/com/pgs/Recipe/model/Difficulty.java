package com.pgs.Recipe.model;

public enum Difficulty {
    ONE("Easy"), TWO("Fairly Easy"), THREE("Mediuem"), FOUR("Fairly Hard"), FIVE("Hard");

    private String tier;

    private Difficulty(String tier) {
        this.tier = tier;
    }

    public static String getDifficulty(int index) {
        return Difficulty.values()[index].toString();
    }
    
    public String getTier() {
        return tier;
    }
}
