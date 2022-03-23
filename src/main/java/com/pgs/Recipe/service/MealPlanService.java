package com.pgs.Recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgs.Recipe.model.MealPlan;
import com.pgs.Recipe.repository.MealPlanDao;

@Service
public class MealPlanService {

    @Autowired
    private MealPlanDao mealPlanDao;

    public List<MealPlan> retrieveAll() {
        return mealPlanDao.findAll();
    }

    public MealPlan retrieveById(long id) {
        return mealPlanDao.findById(id).get();
    }

    public void create(MealPlan newMealPlan) {
        mealPlanDao.save(newMealPlan);
    }
    
}
