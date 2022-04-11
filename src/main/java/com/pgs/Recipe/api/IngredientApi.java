package com.pgs.Recipe.api;

import java.util.List;

import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.service.IngredientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ingredient")
@CrossOrigin(origins="http://172.31.2.122:3000")
public class IngredientApi{

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("ping");
    }
    
    @RequestMapping(value="/AllIngredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients(){
        return ResponseEntity.ok(ingredientService.retrieveAll());
    }
    
    @RequestMapping(value = "/GetIngredient/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long id) {
        Ingredient retrievedIngredient = ingredientService.retrieveById(id);
        if (retrievedIngredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredientService.retrieveById(id));
    }

    @PostMapping(value = "/UpdateIngredient/{id}")
    public ResponseEntity<Ingredient> updateIngredientById(@PathVariable("id") long id, @RequestBody Ingredient updatedIngredient){
        if (ingredientService.update(updatedIngredient)) {
            return ResponseEntity.ok(updatedIngredient);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping(value = "/CreateIngredient")
    public ResponseEntity<Ingredient> createIngredient( @RequestBody Ingredient newIngredient) {
        if (ingredientService.create(newIngredient)){
            return ResponseEntity.ok(newIngredient);
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/SearchIngredient/{name}")
    public ResponseEntity<List<Ingredient>> searchIngredientsByName(@PathVariable("name") String name){
        return ResponseEntity.ok(ingredientService.searchByIngredientName(name));
    }
}
