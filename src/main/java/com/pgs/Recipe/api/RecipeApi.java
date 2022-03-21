package com.pgs.Recipe.api;

import java.util.List;

import com.pgs.Recipe.model.Recipe;
import com.pgs.Recipe.service.RecipeService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("ping");
    }

    @RequestMapping(value = "/recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.retrieveAllRecipes());
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
