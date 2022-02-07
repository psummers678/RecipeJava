package com.pgs.Recipe.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Ingredient> retrieveById(long id) {
        return ingredientDao.findById(id);
    }

    public List<Ingredient> retrieveByName(String name) {
        return ingredientDao.findByIngredientName(name);
    }

    public void update(Ingredient ingredient) {
        ingredientDao.save(ingredient);
    }

    public List<Ingredient> retrieveAll() {
        return null;
    }
    
}
