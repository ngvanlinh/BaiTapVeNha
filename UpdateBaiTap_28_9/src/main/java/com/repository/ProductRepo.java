package com.repository;


import com.model.Product;

public interface ProductRepo {
    boolean insertProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);

    void searchProductByNameCategory(String nameCategory);
    void findNameProduct(String name);

    void SortAsc();

    void SortDesc();

}
