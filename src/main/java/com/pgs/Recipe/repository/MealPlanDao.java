package com.pgs.Recipe.repository;

import com.pgs.Recipe.model.MealPlan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MealPlanDao extends JpaRepository<MealPlan, Long>{
    
}
