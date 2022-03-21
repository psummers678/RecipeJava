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
    
    public boolean createRecipe(Recipe newRecipe) {
        if (recipeDao.findById(newRecipe.getRecipeId()).isPresent()) {
            recipeDao.save(newRecipe);
            return true;
        }
        return false;
    }

    public Recipe retrieveById(long id) {
        if (recipeDao.findById(id).isPresent()){
            return recipeDao.findById(id).get();
        }
        return null;
    }

    public boolean updateRecipe(Recipe recipe) {
        if (recipeDao.findById(recipe.getRecipeId()).isPresent()){
            recipeDao.save(recipe);
            return true;
        }
        return false;
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
