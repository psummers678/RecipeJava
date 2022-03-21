package com.pgs.Recipe.service;

import java.util.List;

import com.pgs.Recipe.model.FoodType;
import com.pgs.Recipe.model.Ingredient;
import com.pgs.Recipe.repository.IngredientDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService{

    @Autowired
    private IngredientDao ingredientDao;

    private final static Logger LOGGER = LogManager.getLogger(IngredientService.class);

    public boolean create(Ingredient ingredient) {
        String ingredientName = ingredient.getIngredientName();
        if ( retrieveByName(ingredientName).isEmpty()) {
            ingredientDao.save(ingredient);
            LOGGER.info("Ingredient Created");
            return true;
        }
        LOGGER.info("Ingredient not created");
        return false;
    }

    public Ingredient retrieveById(long id) {
        return ingredientDao.findById(id).get();
    }

    public List<Ingredient> retrieveByName(String name) {
        return ingredientDao.findByIngredientName(name);
    }

    public boolean update(Ingredient ingredient) {
        if (ingredientDao.findById(ingredient.getIngredientId()).isPresent()){
            ingredientDao.save(ingredient);
            return true;
        }
        return false;
    }

    public List<Ingredient> retrieveAll() {
        return ingredientDao.findAll();
    }

    public List<Ingredient> retrieveAllByFoodType(FoodType foodType) {
        return ingredientDao.findByFoodType(foodType);
    }
    
    public List<Ingredient> searchByIngredientName(String searchString) {
        return ingredientDao.searchByIngredientName(searchString);
    }
    
}
