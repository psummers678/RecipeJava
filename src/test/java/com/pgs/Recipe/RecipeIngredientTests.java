package com.pgs.Recipe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.model.Recipe;
import com.pgs.Recipe.service.IngredientService;
import com.pgs.Recipe.service.RecipeService;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecipeIngredientTests {
   
    @Autowired
    RecipeService recipeService;

    @Autowired
    IngredientService ingredientService;
    
    @Test
    void test_thatAnRecipeCanRetrieveItsIngredients() {
        Recipe retrievedRecipe = recipeService.retrieveById(1);
        Map<Ingredient, String> ingredientRequirements = recipeService.retrieveIngredientRequirementsByRecipe(retrievedRecipe);
        assertTrue(ingredientRequirements.size()!= 0);
    
    }
}
