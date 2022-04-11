package com.pgs.Recipe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.model.IngredientRequirement;
import com.pgs.Recipe.model.Recipe;
import com.pgs.Recipe.service.IngredientRequirementService;
import com.pgs.Recipe.service.IngredientService;
import com.pgs.Recipe.service.RecipeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IngredientRequirementTest {
   
    @Autowired
    RecipeService recipeService;

    @Autowired
    IngredientService ingredientService;
    
    @Autowired
    IngredientRequirementService ingredientRequirementService;
    
    private Ingredient retrievedIngredient;
    private Recipe retrievedRecipe;

    @BeforeEach
    void setUp() {
        retrievedIngredient = ingredientService.retrieveById(1);
        retrievedRecipe = recipeService.retrieveById(1);

    }
    @Test
    void test_thatAIngredientRequirementCanBeCreated() {
    	IngredientRequirement ingredientRequirement = new IngredientRequirement("5 Teaspoons", retrievedIngredient, retrievedRecipe);
    	ingredientRequirementService.create(ingredientRequirement);
    	assertTrue(ingredientRequirement.getIngredientRequirementId() > 0 );
    	
    	
    }

}
