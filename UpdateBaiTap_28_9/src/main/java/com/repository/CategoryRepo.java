package com.repository;


import com.model.Category;

import java.util.List;

public interface CategoryRepo {
    void inserCategory(Category category);

    Category findCategoryById(int id);

    List<Category> findCategoryByName(String nameCategory);

    boolean checkCategory(String name);

}
