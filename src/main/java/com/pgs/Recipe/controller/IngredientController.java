package com.pgs.Recipe.controller;

import java.util.List;

import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.service.IngredientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "/ping")
    public String ping(){
        return "ping";
    }
    
    @RequestMapping(value="/ingredients")
    public  List<Ingredient> getAllIngredients(){
        return ingredientService.retrieveAll();
    }
    
    @RequestMapping(value = "/ingredients/{id}")
    public Ingredient getIngredientById(@PathVariable("id") Long id) {
        return ingredientService.retrieveById(id);
    }

    @PostMapping(value = "/ingredients/{id}")
    public void updateIngredientById(@RequestBody Ingredient updatedIngredient){
        ingredientService.update(updatedIngredient);

    }

    @PostMapping(value = "/ingredients")
    public void createIngredient(@RequestBody Ingredient newIngredient) {
        ingredientService.create(newIngredient);
    }

    @RequestMapping(value = "/ingredients/search/{name}")
    public List<Ingredient> searchIngredientsByName(@PathVariable("name") String name){
        return ingredientService.searchByIngredientName(name);
    }
}
