package jdbc.repository;

import org.jdbc.model.Product;

public interface ProductRepo {
    boolean checkProduct(String nameCategory);
    void selectProduct();
    void updateProduct(Product product,int id);
    void deleteProduct(int id);
    void SortDesc();
    void SortAsc();
    void searchProductName(String nameProduct);
    void searchCategoryName(String nameCategory);
}
