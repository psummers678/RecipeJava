package com.pgs.Recipe.model;

public enum ShelfLifeUnit {
    DAYS("Days"), YEARS("Years"), MONTHS("Months"), WEEKS("Weeks");
    private String unit;

    private ShelfLifeUnit(String unit){
        this.unit = unit;
    }
    
    public String getUnit(){
        return unit;
    }
}
