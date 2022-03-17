package com.pgs.Recipe.model;

public enum FoodType {
    MEAT("Meat"), FRUIT("Fruit"), VEG("Veg");

    private String foodType;

    private FoodType(String foodType){
        this.foodType = foodType;
    }

}
