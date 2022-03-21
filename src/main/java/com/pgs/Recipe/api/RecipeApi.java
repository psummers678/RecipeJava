package com.pgs.Recipe.api;

import java.util.List;

import com.pgs.Recipe.model.Recipe;
import com.pgs.Recipe.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeApi {

    @Autowired
    private RecipeService recipeService; 

    @RequestMapping(value = "/recipe/ping")
    public String ping() {
        return "ping";
    }

    @RequestMapping(value = "/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.retrieveAllRecipes();
    }

    @RequestMapping(value = "/recipes/{id}")
    public Recipe getRecipeById(@PathVariable("id") Long id) {
        return recipeService.retrieveById(id);
    }
    
    @PostMapping(value = "/recipe/{id}")
    public void updateRecipeId(@RequestBody Recipe updatedRecipe) {
        recipeService.updateRecipe(updatedRecipe);
    }

    @PostMapping(value ="/recipes")
    public void createRecipe(@RequestBody Recipe newRecipe) {
        recipeService.createRecipe(newRecipe);
    }
}
