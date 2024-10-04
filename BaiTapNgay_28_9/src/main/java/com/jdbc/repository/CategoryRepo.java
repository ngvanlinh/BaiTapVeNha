package jdbc.repository;

import org.jdbc.model.Category;

public interface CategoryRepo {
    void inserCategory(Category category);
    void searchCategoryById(int id);
    void searchCategoryByName(String name);
}
