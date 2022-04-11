package com.pgs.Recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgs.Recipe.model.IngredientRequirement;

public interface IngredientRequirementDao extends JpaRepository<IngredientRequirement, Long>{

}
