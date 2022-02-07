package com.pgs.Recipe.controller;

import java.util.List;

import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.service.IngredientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value="/ingredients")
    public List<Ingredient> getAllIngredients(){
        return ingredientService.retrieveAll();
    }
    
}
