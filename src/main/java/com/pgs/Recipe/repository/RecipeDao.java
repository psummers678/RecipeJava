package com.pgs.Recipe.repository;

import com.pgs.Recipe.model.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDao extends JpaRepository<Recipe,Long>{

    Recipe findByRecipeName(String recipeName);
    
}
