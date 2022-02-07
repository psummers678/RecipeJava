package com.pgs.Recipe.service;

import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.repository.IngredientDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService{

    @Autowired
    private IngredientDao ingredientDao;

    public void create(Ingredient ingredient) {
        ingredientDao.save(ingredient);

    }
    
}
