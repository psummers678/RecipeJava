package com.pgs.Recipe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecipeApplicationTests {

    
	@Test
	void test_IngredientCanBeCreated() {
        Ingredient ingredient = new Ingredient();
        IngredientService ingredienceService = new IngredientService();
        ingredienceService.create(ingredient);

        assertTrue(ingredient.getId() > 0);

	}

}
