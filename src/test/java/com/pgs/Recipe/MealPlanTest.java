package com.pgs.Recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.pgs.Recipe.model.MealPlan;
import com.pgs.Recipe.model.Recipe;
import com.pgs.Recipe.service.MealPlanService;
import com.pgs.Recipe.service.RecipeService;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MealPlanTest {
    
    @Autowired
    private MealPlanService mealPlanService; 
    
    @Autowired
    private RecipeService recipeService;

    @Test
    void test_thatAllMealPlansCanBeRetrievedFromDB() {
        List<MealPlan> allMealPlans = mealPlanService.retrieveAll();
        assertTrue(allMealPlans.size() > 0);
    }

    @Test
    void test_thatASingularMealPlanCanBeRetrievedById() {
        MealPlan retrievedMealPlan = mealPlanService.retrieveById(1);
        assertEquals(5.59, retrievedMealPlan.getEstimatedCost());
    }

    @Test
    void test_thatAMealPlanCanBePersisted(){
        List<Recipe> plannedRecipes = new ArrayList<Recipe>();
        plannedRecipes.add(recipeService.retrieveById(1));
        MealPlan newMealPlan = new MealPlan(3.56, plannedRecipes);
        mealPlanService.create(newMealPlan);
        assertTrue(newMealPlan.getMealPlanId()>0);
    }
}
