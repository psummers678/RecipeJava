package com.pgs.Recipe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity 
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_generator")
    @SequenceGenerator( name = "ingredient_generator", sequenceName ="INGREDIENT_SEQ", allocationSize = 1)
    private long ingredientId;

    @Column
    private String ingredientName;

    @Column 
    private double price;

    public Ingredient(String ingredientName, double price) {
        super();
        this.ingredientName = ingredientName;
        this.price = price;
    }

    public Ingredient() {
        super();
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
