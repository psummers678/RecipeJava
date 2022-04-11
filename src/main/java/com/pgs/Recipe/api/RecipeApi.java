package com.pgs.Recipe.api;

import java.util.List;

import com.pgs.Recipe.model.Recipe;
import com.pgs.Recipe.service.RecipeService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recipe")
@CrossOrigin(origins="http://172.31.2.122:3000")
public class RecipeApi {

	private final static Logger LOGGER = LogManager.getLogger();
	
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

    @RequestMapping(value = "GetRecipeByName/{name}")
    public ResponseEntity<Recipe> getRecipeByName(@PathVariable("name") String name) {
        Recipe retrievedRecipe = recipeService.retrieveByName(name);
        if (retrievedRecipe != null) {
            ResponseEntity.ok(retrievedRecipe);
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

    @PostMapping(value ="/CreateRecipe", consumes = {"application/json"})
    public void createRecipe(@RequestBody Recipe newRecipe) {
    	LOGGER.error("OBJECT PROVIDED IS :" + newRecipe);
        recipeService.createRecipe(newRecipe);
    }
}
