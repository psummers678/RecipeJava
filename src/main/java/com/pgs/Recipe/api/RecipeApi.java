package com.pgs.Recipe.api;

import java.util.List;

import com.pgs.Recipe.model.Recipe;
import com.pgs.Recipe.service.RecipeService;

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

    @RequestMapping(value = "/AllRecipes")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.retrieveAllRecipes());
    }

    @RequestMapping(value = "/GetRecipe/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id) {
        Recipe retrievedRecipe = recipeService.retrieveById(id);
        if (retrievedRecipe != null) {
            return ResponseEntity.ok(retrievedRecipe);
        }
        return ResponseEntity.notFound().build();
}

    
    @PostMapping(value = "/UpdateRecipe/{id}")
    public void updateRecipeId(@RequestBody Recipe updatedRecipe) {
        if (recipeService.updateRecipe(updatedRecipe)) {
            ResponseEntity.ok(updatedRecipe);
        }
        ResponseEntity.notFound().build();
    }

    @PostMapping(value ="/CreateRecipe")
    public void createRecipe(@RequestBody Recipe newRecipe) {

        recipeService.createRecipe(newRecipe);
    }
}
