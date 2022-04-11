package com.pgs.Recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgs.Recipe.model.IngredientRequirement;
import com.pgs.Recipe.repository.IngredientRequirementDao;

@Service
public class IngredientRequirementService {

	@Autowired
	private IngredientRequirementDao ingredientRequirementDao;
	
	public void create(IngredientRequirement newIngredientRequirement) {
		ingredientRequirementDao.save(newIngredientRequirement);
	}
}
