package com.pgs.Recipe.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class MealPlan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mealplan_gen")
    @SequenceGenerator(name = "mealplan_gen", sequenceName = "MEALPLAN_SEQ", allocationSize = 1)
    private long mealPlanId;

    @Column
    private double estimatedCost;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "MEALPLAN_RECIPES")
    private List<Recipe> plannedRecipes;

    public MealPlan(double estimatedCost, List<Recipe> plannedRecipes) {
        super();
        this.estimatedCost = estimatedCost;
        this.plannedRecipes = plannedRecipes;
    }

    public MealPlan() {
    }

    public long getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(long mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public List<Recipe> getPlannedRecipes() {
        return plannedRecipes;
    }

    public void setPlannedRecipes(List<Recipe> plannedRecipes) {
        this.plannedRecipes = plannedRecipes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(estimatedCost);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (int) (mealPlanId ^ (mealPlanId >>> 32));
        result = prime * result + ((plannedRecipes == null) ? 0 : plannedRecipes.hashCode());
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
        MealPlan other = (MealPlan) obj;
        if (Double.doubleToLongBits(estimatedCost) != Double.doubleToLongBits(other.estimatedCost))
            return false;
        if (mealPlanId != other.mealPlanId)
            return false;
        if (plannedRecipes == null) {
            if (other.plannedRecipes != null)
                return false;
        } else if (!plannedRecipes.equals(other.plannedRecipes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MealPlan [estimatedCost=" + estimatedCost + ", mealPlanId=" + mealPlanId + ", plannedRecipes="
                + plannedRecipes + "]";
    }
}
