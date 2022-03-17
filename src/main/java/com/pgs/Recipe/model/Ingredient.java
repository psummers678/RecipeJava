package com.pgs.Recipe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity 
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_generator")
    @SequenceGenerator( name = "ingredient_generator", sequenceName ="INGREDIENT_SEQ", allocationSize = 1)
    private long ingredientId;

    @Column
    private String ingredientName;

    @Column 
    private double price;

    @Column
    private String shopName;

    @Column
    private long shelfLife;

    @Enumerated(EnumType.STRING)
    private ShelfLifeUnit shelfLifeUnit;

    @Enumerated(EnumType.STRING)
    private StorageType storageType;

    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    public Ingredient(String ingredientName, double price, String string, long shelfLife, ShelfLifeUnit days, StorageType fridge, FoodType meat) {
        super();
        this.ingredientName = ingredientName;
        this.price = price;
        this.shopName = shopName;
        this.shelfLifeUnit = shelfLifeUnit;
        this.shelfLife = shelfLife;
        this.storageType = storageType;
        this.foodType = foodType;
    }

    public Ingredient() {
        super();
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (ingredientId ^ (ingredientId >>> 32));
        result = prime * result + ((ingredientName == null) ? 0 : ingredientName.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Ingredient other = (Ingredient) obj;
        if (ingredientId != other.ingredientId)
            return false;
        if (ingredientName == null) {
            if (other.ingredientName != null)
                return false;
        } else if (!ingredientName.equals(other.ingredientName))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient [foodType=" + foodType + ", ingredientId=" + ingredientId + ", ingredientName="
                + ingredientName + ", price=" + price + "]";
    }

}
