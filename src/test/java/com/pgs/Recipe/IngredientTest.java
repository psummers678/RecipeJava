package com.pgs.Recipe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.service.IngredientService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IngredientTest {

    
	@Test
	void test_IngredientCanBeCreated() {
        Ingredient ingredient = new Ingredient();
        IngredientService ingredienceService = new IngredientService();
        ingredienceService.create(ingredient);

        assertTrue(ingredient.getId() > 0);

	}

}
