package com.pgs.Recipe.repository;

import java.util.List;

import com.pgs.Recipe.model.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Long> {
    
    List<Ingredient> findByIngredientName(String ingredientName);
}
