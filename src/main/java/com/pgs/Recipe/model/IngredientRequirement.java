package com.pgs.Recipe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class IngredientRequirement {

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator="ingredient_requirement_seq")
	@SequenceGenerator( name = "ingredient_requirement_seq", sequenceName = "INGREDIENTREQ_SEQ", allocationSize = 1)
	private long ingredientRequirementId;
	
	@Column
	private String quantity;
	
	@ManyToOne
	private Ingredient requiredIngredient;
	
	@ManyToOne
	private Recipe recipe;

	public IngredientRequirement(String quantity, Ingredient requiredIngredient, Recipe recipe) {
		super();
		this.quantity = quantity;
		this.requiredIngredient = requiredIngredient;
		this.recipe = recipe;
	}

	public IngredientRequirement() {
		super();
	}

	public long getIngredientRequirementId() {
		return ingredientRequirementId;
	}

	public void setIngredientRequirementId(long ingredientRequirementId) {
		this.ingredientRequirementId = ingredientRequirementId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Ingredient getRequiredIngredient() {
		return requiredIngredient;
	}

	public void setRequiredIngredient(Ingredient requiredIngredient) {
		this.requiredIngredient = requiredIngredient;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "IngredientRequirement [ingredientRequirementId=" + ingredientRequirementId + ", quantity=" + quantity
				+ ", requiredIngredient=" + requiredIngredient + ", recipe=" + recipe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ingredientRequirementId ^ (ingredientRequirementId >>> 32));
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + ((requiredIngredient == null) ? 0 : requiredIngredient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IngredientRequirement other = (IngredientRequirement) obj;
		if (ingredientRequirementId != other.ingredientRequirementId)
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (recipe == null) {
			if (other.recipe != null)
				return false;
		} else if (!recipe.equals(other.recipe))
			return false;
		if (requiredIngredient == null) {
			if (other.requiredIngredient != null)
				return false;
		} else if (!requiredIngredient.equals(other.requiredIngredient))
			return false;
		return true;
	}
	
	
	
}
