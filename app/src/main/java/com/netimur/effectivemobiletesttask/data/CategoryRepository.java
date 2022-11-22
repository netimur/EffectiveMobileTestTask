package com.netimur.effectivemobiletesttask.data;

import com.netimur.effectivemobiletesttask.R;
import com.netimur.effectivemobiletesttask.ui.mainpage.categories.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(R.drawable.ic_books, "Books"));
        categories.add(new Category(R.drawable.ic_computer, "Computer"));
        categories.add(new Category(R.drawable.ic_phones, "Phones"));
        categories.add(new Category(R.drawable.ic_heart, "Health"));
        return categories;
    }
}
