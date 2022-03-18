package com.pgs.Recipe.repository;

import java.util.List;

import com.pgs.Recipe.model.Difficulty;
import com.pgs.Recipe.model.Rating;
import com.pgs.Recipe.model.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDao extends JpaRepository<Recipe,Long>{

    Recipe findByRecipeName(String recipeName);
    List<Recipe> findByRating(Rating rating);
    List<Recipe> findByDifficulty(Difficulty difficulty);
    
}
