package com.pgs.Recipe.service;

import java.util.List;

import com.pgs.Recipe.model.Difficulty;
import com.pgs.Recipe.model.Rating;
import com.pgs.Recipe.model.Recipe;
import com.pgs.Recipe.repository.RecipeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeDao recipeDao;
    
    public void createRecipe(Recipe newRecipe) {
        recipeDao.save(newRecipe);
    }

    public Recipe retrieveById(long id) {
        return recipeDao.findById(id).get();
    }

    public void updateRecipe(Recipe recipe) {
        recipeDao.save(recipe);
    }

    public Recipe retrieveByName(String recipeName) {
        return recipeDao.findByRecipeName(recipeName);
    }
    
    public List<Recipe> retrieveAllRecipes() {
        return recipeDao.findAll();
    }

    public List<Recipe> retrieveRecipesByRating(Rating rating) {
        return recipeDao.findByRating(rating);
    }

    public List<Recipe> retrieveRecipesByDifficulty(Difficulty difficulty) {
        return recipeDao.findByDifficulty(difficulty);
    }

}
