package com.pgs.Recipe.model;

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

    public long getId() {
        return ingredientId;
    }

    



}
