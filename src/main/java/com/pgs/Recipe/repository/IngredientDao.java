package com.pgs.Recipe.repository;

import java.util.List;

import com.pgs.Recipe.model.FoodType;
import com.pgs.Recipe.model.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Long> {
    
    List<Ingredient> findByIngredientName(String ingredientName);
    List<Ingredient> findByFoodType(FoodType foodType);
    
    @Query("select i from Ingredient i where lower(i.ingredientName) like concat('%', lower(:searchString),'%')")
    List<Ingredient> searchByIngredientName(@Param("searchString") String searchString);
}
