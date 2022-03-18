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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public long getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(long shelfLife) {
        this.shelfLife = shelfLife;
    }

    public ShelfLifeUnit getShelfLifeUnit() {
        return shelfLifeUnit;
    }

    public void setShelfLifeUnit(ShelfLifeUnit shelfLifeUnit) {
        this.shelfLifeUnit = shelfLifeUnit;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((foodType == null) ? 0 : foodType.hashCode());
        result = prime * result + (int) (ingredientId ^ (ingredientId >>> 32));
        result = prime * result + ((ingredientName == null) ? 0 : ingredientName.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (int) (shelfLife ^ (shelfLife >>> 32));
        result = prime * result + ((shelfLifeUnit == null) ? 0 : shelfLifeUnit.hashCode());
        result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
        result = prime * result + ((storageType == null) ? 0 : storageType.hashCode());
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
        if (foodType != other.foodType)
            return false;
        if (ingredientId != other.ingredientId)
            return false;
        if (ingredientName == null) {
            if (other.ingredientName != null)
                return false;
        } else if (!ingredientName.equals(other.ingredientName))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (shelfLife != other.shelfLife)
            return false;
        if (shelfLifeUnit != other.shelfLifeUnit)
            return false;
        if (shopName == null) {
            if (other.shopName != null)
                return false;
        } else if (!shopName.equals(other.shopName))
            return false;
        if (storageType != other.storageType)
            return false;
        return true;
    }



}
