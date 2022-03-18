package com.pgs.Recipe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "recipe_gen")
    @SequenceGenerator(name = "recipe_gen", sequenceName = "RECIPE_SEQ", allocationSize = 1)
    private long recipeId;

    public Recipe() {
        super();
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }
    
    
}
