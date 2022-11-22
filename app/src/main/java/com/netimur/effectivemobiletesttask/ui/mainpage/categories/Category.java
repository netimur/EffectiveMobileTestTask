package com.netimur.effectivemobiletesttask.ui.mainpage.categories;

public class Category {
    private final int imageResourceId;
    private final String categoryName;

    public Category(int imageResourceId, String categoryName) {
        this.imageResourceId = imageResourceId;
        this.categoryName = categoryName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
