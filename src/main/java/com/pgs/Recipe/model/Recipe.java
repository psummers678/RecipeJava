package com.pgs.Recipe.model;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.SequenceGenerator;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "recipe_gen")
    @SequenceGenerator(name = "recipe_gen", sequenceName = "RECIPE_SEQ", allocationSize = 1)
    private long recipeId;

    @Column
    private String recipeName;

    @Column
    private long recipeDurationMins;

    @Lob
    @Column
    private String recipeBody;

    @ElementCollection
    @CollectionTable
    @MapKeyColumn
    @Column
    private Map<Ingredient, String> ingredientRequirements;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    
    public Recipe(String recipeName, long recipeDurationMins, String recipeBody,
            Map<Ingredient, String> ingredientRequirements, Rating rating, Difficulty difficulty) {
        this.recipeName = recipeName;
        this.recipeDurationMins = recipeDurationMins;
        this.recipeBody = recipeBody;
        this.ingredientRequirements = ingredientRequirements;
        this.rating = rating;
        this.difficulty = difficulty;
    }

    public Recipe() {
        super();
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Long getRecipeDurationMins() {
        return recipeDurationMins;
    }

    public void setRecipeDurationMins(Long recipeDurationMins) {
        this.recipeDurationMins = recipeDurationMins;
    }

    public String getRecipeBody() {
        return recipeBody;
    }

    public void setRecipeBody(String recipeBody) {
        this.recipeBody = recipeBody;
    }

    public Map<Ingredient, String> getIngredientRequirements() {
        return ingredientRequirements;
    }

    public void setIngredientRequirements(Map<Ingredient, String> ingredientRequirements) {
        this.ingredientRequirements = ingredientRequirements;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
        result = prime * result + ((ingredientRequirements == null) ? 0 : ingredientRequirements.hashCode());
        result = prime * result + ((rating == null) ? 0 : rating.hashCode());
        result = prime * result + ((recipeBody == null) ? 0 : recipeBody.hashCode());
        result = prime * result + (int) (recipeDurationMins ^ (recipeDurationMins >>> 32));
        result = prime * result + (int) (recipeId ^ (recipeId >>> 32));
        result = prime * result + ((recipeName == null) ? 0 : recipeName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Recipe other = (Recipe) obj;
        if (difficulty != other.difficulty)
            return false;
        if (ingredientRequirements == null) {
            if (other.ingredientRequirements != null)
                return false;
        } else if (!ingredientRequirements.equals(other.ingredientRequirements))
            return false;
        if (rating != other.rating)
            return false;
        if (recipeBody == null) {
            if (other.recipeBody != null)
                return false;
        } else if (!recipeBody.equals(other.recipeBody))
            return false;
        if (recipeDurationMins != other.recipeDurationMins)
            return false;
        if (recipeId != other.recipeId)
            return false;
        if (recipeName == null) {
            if (other.recipeName != null)
                return false;
        } else if (!recipeName.equals(other.recipeName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Recipe [difficulty=" + difficulty + ", rating="
                + rating +  ", recipeDurationMins=" + recipeDurationMins + ", recipeId="
                + recipeId + ", recipeName=" + recipeName + "]";
    }

}
