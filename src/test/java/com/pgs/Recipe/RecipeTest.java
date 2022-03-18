package com.pgs.Recipe;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.pgs.Recipe.model.Recipe;
import com.pgs.Recipe.service.RecipeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecipeTest {
    
    @Autowired
    private RecipeService recipeService;
    private Recipe retrievedRecipe;
    
    @BeforeEach
    void setUp() {

    }

    @Test
    void test_thatABlankRecipeCanBeCreated(){
        Recipe newRecipe = new Recipe();
        recipeService.create(newRecipe);
        assertNotEquals(0, newRecipe.getRecipeId());;

    }
}
