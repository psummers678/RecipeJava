package com.pgs.Recipe.model;

public enum StorageType {
    FRIDGE("Fridge"), NORMAL("Normal");
    private String storageType;

    private StorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageType() {
        return storageType;
    }
}
