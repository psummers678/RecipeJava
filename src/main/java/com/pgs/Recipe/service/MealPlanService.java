package com.pgs.Recipe.service;

import java.util.ArrayList;
import java.util.List;

import com.pgs.Recipe.model.MealPlan;

import org.springframework.stereotype.Service;

@Service
public class MealPlanService {

    public List<MealPlan> retrieveAll() {
        return new ArrayList<MealPlan>();
    }
    
}
