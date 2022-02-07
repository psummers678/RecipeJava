package com.pgs.Recipe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.service.IngredientService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IngredientTest {

    @Autowired
    private IngredientService ingredientService;
	@Test
	void test_IngredientCanBeCreated() {
        Ingredient ingredient = new Ingredient();
        ingredientService.create(ingredient);
        assertTrue(ingredient.getId() > 0);

	}

    @Test
    void test_TwoIngredientsCanBeCreatedWithGeneratedIds() {
        Ingredient ingredient = new Ingredient();
        Ingredient ingredient2 = new Ingredient();
        
        ingredientService.create(ingredient);
        ingredientService.create(ingredient2);
        assertTrue(ingredient.getId() != ingredient2.getId());

    }

}
