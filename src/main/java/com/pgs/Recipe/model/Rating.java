package com.pgs.Recipe.model;

public enum Rating {
    ONE("*"), TWO("**"), THREE("***"), FOUR("****"), FIVE("*****");

    private String rating;

    private Rating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

}
