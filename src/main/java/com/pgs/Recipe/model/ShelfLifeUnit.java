package com.pgs.Recipe.model;

public enum ShelfLifeUnit {
    DAYS("Days"), YEARS("Years"), MONTHS("Months");
    private String unit;

    private ShelfLifeUnit(String unit){
        this.unit = unit;
    }
    
}
