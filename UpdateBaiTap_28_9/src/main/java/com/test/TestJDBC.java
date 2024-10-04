package com.test;

import com.connection.DatabaseConnection;
import com.model.Category;
import com.model.Product;
import com.services.CategoryService;
import com.services.ProductService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
            findCategoryByName();
        } else if (n == 4) {
            checkIsExistCategory();
        } else if (n == 5) {
            updateProduct();
        } else if (n == 6) {
            deleteProductById();
        } else if (n==7) {
            productService.SortAsc();
        } else if (n==8) {
            productService.SortDesc();
        } else if (n==9) {
            searchProductByName();
        } else if (n==10) {
            searchProductByNameCat();
        } else if (n==11) {


        }
    }

    static void insertCategoory() {
        System.out.print("Nhập tên category muốn thêm mới: ");
        String nameCategory = sc.next();

        Category cat = new Category(nameCategory);
        categoryService.inserCategory(cat);
    }

    static void selectCategoryById() {
        System.out.println("nhập id Category cần tìm");
        int id = sc.nextInt();
        categoryService.findCategoryById(id);
    }

    static void findCategoryByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cateory cần tim");
        String name = scanner.nextLine();
        List<Category> categoryList =categoryService.findCategoryByName(name);
        System.out.println(categoryList);
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
        Product pro = new Product(id, name, price, new Category(cat_id));
        Category cat = new Category(cat_id);
        productService.updateProduct(pro);

    }

    static void deleteProductById() {
        System.out.println("Nhập id cần xóa");
        int id = sc.nextInt();
        productService.deleteProduct(id);
    }
    static void searchProductByName(){
        System.out.println("nhập tên product cần tim");
        String name = sc.next();
        productService.findNameProduct(name);

    }
    static void searchProductByNameCat(){
        System.out.println("nhập tên Category cần tim");
        String name = sc.next();
        sc.nextLine();
        productService.searchProductByNameCategory(name);
    }
    static void checkIsExistCategory(){
        Category category = new Category("insert test category - 2");
        Product product = new Product("Product new 3",121);
        if(categoryService.checkCategory(category.getNameCategory())){
            List<Category> categoryList = categoryService.findCategoryByName(category.getNameCategory());
            Category cat = categoryList.get(0);
            product.setCat_id(cat);
            if (productService.insertProduct(product)){
                System.out.println("thành công");
            }else {
                System.out.println("thất bại");
            }

        }else {
            categoryService.inserCategory(category);
            List<Category> categoryList = categoryService.findCategoryByName(category.getNameCategory());
            Category cat = categoryList.get(0);
            product.setCat_id(cat);
            if (productService.insertProduct(product)){
                System.out.println("thành công");
            }else {
                System.out.println("thất bại");
            }
        }
    }
}
