package com.pgs.Recipe.repository;

import com.pgs.Recipe.model.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDao extends JpaRepository<Ingredient, Long> {
    
}
