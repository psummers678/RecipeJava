package com.pgs.Recipe.service;

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
}