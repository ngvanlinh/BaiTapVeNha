package org.jdbc;

import org.jdbc.model.Category;
import org.jdbc.model.Product;
import org.jdbc.services.CategoryService;
import org.jdbc.services.ProductService;

import java.util.Scanner;

public class TestJDBC {
    private static Scanner sc = new Scanner(System.in);
    private static CategoryService categoryService = new CategoryService();
    private static ProductService productService = new ProductService();

    public static void main(String[] args) {
        System.out.println("nhập chức năng cần sử lí: ");
        System.out.println("1: thêm mới category\n" +
                "2: tìm Category theo id\n" +
                "3: tìm Category theo tên\n" +
                "4: thêm mới Product\n" +
                "5: sửa Product\n" +
                "6: xóa Product\n" +
                "7: sắp xếp giảm dần theo price\n" +
                "8: sắp xếp tăng theo price\n" +
                "9: tìm kiếm product theo tên\n" +
                "10: tìm kiếm product theo tên category\n");
        int n = sc.nextInt();
        if (n == 1) {
            insertCategoory();
        } else if (n == 2) {
            selectCategoryById();
        } else if (n == 3) {
            selectCategoryByName();

        } else if (n == 4) {
            insertProduct();
        } else if (n == 5) {
            updateProduct();
        } else if (n == 6) {
            deleteProductById();
        } else if (n==7) {
            productService.SortDesc();
        } else if (n==8) {
            productService.SortAsc();
        } else if (n==9) {
            searchProductByName();
        } else if (n==10) {
            searchProductByNameCat();
        }
    }

    static void insertCategoory() {
        System.out.println("Nhập tên category muốn thêm mới: ");
        String nameCategory = sc.next();
        Category cat = new Category(nameCategory);
        categoryService.inserCategory(cat);
    }

    static void selectCategoryById() {
        System.out.println("nhập id Category cần tìm");
        int id = sc.nextInt();
        categoryService.searchCategoryById(id);
    }

    static void selectCategoryByName() {
        System.out.println("nhập tên cateory cần tim");
        String name = sc.next();
        categoryService.searchCategoryByName(name);
    }

    static void insertProduct() {
        System.out.println("Nhập category muốn thêm sản phẩm");
        String nameCat = sc.next();
        if (productService.checkProduct(nameCat) == true) {
            System.out.println("Nhập product muốn thêm mới:");
            String nameProduct = sc.next();
            System.out.println("Nhập giá: ");
            double price = sc.nextDouble();
            System.out.println("Nhập cat_id: ");
            int cat_id = sc.nextInt();
            Product pro = new Product(nameProduct, price, cat_id);
            productService.insertProduct(pro);
            productService.prinProduct(nameCat);
        } else {
            System.out.println("không có Category nào tên " + nameCat);
        }
    }

    static void updateProduct() {
        System.out.println("Nhập id Product cần sửa:");
        int id = sc.nextInt();
        System.out.println("Nhập tên Product cần sửa");
        String name = sc.next();
        System.out.println("Nhập giá cần sửa");
        double price = sc.nextDouble();
        System.out.println("Nhập cat_id muốn sửa");
        int cat_id = sc.nextInt();
        Product pro = new Product(id, name, price, cat_id);
        productService.updateProduct(pro, id);
        productService.selectProduct();
    }

    static void deleteProductById() {
        System.out.println("Nhập id cần xóa");
        int id = sc.nextInt();
        productService.deleteProduct(id);
        productService.selectProduct();
    }
    static void searchProductByName(){
        System.out.println("nhập tên product cần tim");
        String name = sc.next();
        productService.searchProductName(name);
    }
    static void searchProductByNameCat(){
        System.out.println("nhập tên Category cần tim");
        String name = sc.next();
        productService.searchCategoryName(name);
    }
}
