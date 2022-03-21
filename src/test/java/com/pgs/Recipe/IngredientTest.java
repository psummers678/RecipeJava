package com.pgs.Recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.booleanThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.pgs.Recipe.model.FoodType;
import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.model.ShelfLifeUnit;
import com.pgs.Recipe.model.StorageType;
import com.pgs.Recipe.service.IngredientService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
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
        Ingredient ingredient = new Ingredient(ingredientName, price, "Test", 5, ShelfLifeUnit.DAYS, StorageType.FRIDGE, FoodType.MEAT);
        ingredientService.create(ingredient);
        assertEquals(ingredient.getIngredientName(),ingredientName);
        assertEquals(ingredient.getPrice(), price);
    }

    @Test
    void test_IngredientCanBeRetrievedById() {
        Ingredient setupIngredient = new Ingredient("First Ingredient", 0.5, "Test", 5, ShelfLifeUnit.DAYS, StorageType.FRIDGE, FoodType.MEAT);
        ingredientService.create(setupIngredient);
        Ingredient retrievedIngredient = ingredientService.retrieveById(setupIngredient.getIngredientId());
        assertEquals(retrievedIngredient, setupIngredient);
    }

    @Test
    void test_IngredientCanBeUpdated(){
        Ingredient setupIngredient = new Ingredient("First Ingredient", 0.5, "Test", 5, ShelfLifeUnit.DAYS, StorageType.FRIDGE, FoodType.MEAT);
        ingredientService.create(setupIngredient);
        String newName = "new name";
        setupIngredient.setIngredientName(newName);
        ingredientService.update(setupIngredient);
        Ingredient retrievedIngredient = ingredientService.retrieveById(setupIngredient.getIngredientId());
        assertEquals(retrievedIngredient, setupIngredient);
    }

    @Test
    void test_IngredientCanBeRetrievedByName() {
        String name = "retrievedName";
        Ingredient ingredient = new Ingredient(name, 0.5, "Test", 5, ShelfLifeUnit.DAYS, StorageType.FRIDGE, FoodType.MEAT);
        ingredientService.create(ingredient);
        Ingredient retrievedIngredient = ingredientService.retrieveByName(name).get(0);
        assertEquals(ingredient, retrievedIngredient);
    }

    @Test
    void test_IngredientsCanAllBeRetrieved() {
        Integer randomLength = (int)(10*Math.random());
        for (Integer i = 0; i < randomLength; i++) {
            ingredientService.create(new Ingredient("name"+i.toString(), 0.05, "Test", 5, ShelfLifeUnit.DAYS, StorageType.FRIDGE, FoodType.MEAT));
        }
        List<Ingredient> allIngredients = ingredientService.retrieveAll();
        assertEquals(allIngredients.size(), randomLength +4);
        
    }

     @Test
     void test_thatAnIngredientCanBeRetrievedByFoodType(){
         List<Ingredient> expected = new ArrayList<Ingredient> (); 
         Ingredient firstIngredient = ingredientService.retrieveById(2);
         Ingredient secondIngredient = ingredientService.retrieveById(4);
         expected.add(firstIngredient);
         expected.add(secondIngredient);
         List<Ingredient> retrieved = ingredientService.retrieveAllByFoodType(FoodType.MEAT);
         assertEquals(expected, retrieved);

     }

    @Test
    void test_thatAnIngredientCanBeSearchedByName(){
        List<Ingredient> expected = new ArrayList<Ingredient>();
        Ingredient firstIngredient = ingredientService.retrieveById(2);
        Ingredient secondIngredient = ingredientService.retrieveById(4);
        expected.add(firstIngredient);
        expected.add(secondIngredient);
        List<Ingredient> retrieved = ingredientService.searchByIngredientName("eak");
        assertEquals(expected, retrieved);
    }

    @Test
    void test_thatAnIngredientCannotBeCreatedIfItAlreadyExists() {
        String newIngredientName = ingredientService.retrieveById(1).getIngredientName();
        Ingredient newIngredient = new Ingredient(newIngredientName, 5.56, "Tescos", 5, ShelfLifeUnit.DAYS, StorageType.FRIDGE, FoodType.FRUIT);
        Boolean result = ingredientService.create(newIngredient);
        assertFalse(result);

    }

}
