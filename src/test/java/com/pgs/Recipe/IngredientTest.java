package com.pgs.Recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.service.IngredientService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

@SpringBootTest
class IngredientTest {

    @Autowired
    private IngredientService ingredientService;

	@Test
	void test_IngredientCanBeCreated() {
        Ingredient ingredient = new Ingredient();
        ingredientService.create(ingredient);
        assertTrue(ingredient.getIngredientId() > 0);
	}

    @Test
    void test_TwoIngredientsCanBeCreatedWithGeneratedIds() {
        Ingredient ingredient = new Ingredient();
        Ingredient ingredient2 = new Ingredient();
        ingredientService.create(ingredient);
        ingredientService.create(ingredient2);
        assertTrue(ingredient.getIngredientId() != ingredient2.getIngredientId());
    }

    @Test
    void test_IngredientCanBeCreatedWithNameAndPrice(){
        String ingredientName = "Flour";
        double price = 0.5;
        Ingredient ingredient = new Ingredient(ingredientName, price);
        ingredientService.create(ingredient);
        assertEquals(ingredient.getIngredientName(),ingredientName);
        assertEquals(ingredient.getPrice(), price);
    }

    @Test
    void test_IngredientCanBeRetrievedById() {
        Ingredient setupIngredient = new Ingredient("First Ingredient", 0.5);
        ingredientService.create(setupIngredient);
        Ingredient retrievedIngredient = ingredientService.retrieveById(setupIngredient.getIngredientId()).get();
        assertEquals(retrievedIngredient, setupIngredient);
    }

    @Test
    void test_IngredientCanBeUpdated(){
        Ingredient setupIngredient = new Ingredient("First Ingredient", 0.5);
        ingredientService.create(setupIngredient);
        String newName = "new name";
        setupIngredient.setIngredientName(newName);
        ingredientService.update(setupIngredient);
        Ingredient retrievedIngredient = ingredientService.retrieveById(setupIngredient.getIngredientId()).get();
        assertEquals(retrievedIngredient, setupIngredient);
    }

    @Test
    void test_IngredientCanBeRetrievedByName() {
        String name = "retrievedName";
        Ingredient ingredient = new Ingredient(name, 0.5);
        ingredientService.create(ingredient);
        Ingredient retrievedIngredient = ingredientService.retrieveByName(name).get(0);
        assertEquals(ingredient, retrievedIngredient);
    }

}
