package com.model;

public class Product {
    private int id;
    private Category cat_id;
    private String nameProduct;
    private double price;

    public Product(int id, String nameProduct, double price, Category cat_id) {
        this.id = id;
        this.price = price;
        this.nameProduct = nameProduct;
        this.cat_id = cat_id;
    }

    public Product() {
    }

    public Product(String nameProduct, double price, Category cat_id) {
        this.price = price;
        this.nameProduct = nameProduct;
        this.cat_id = cat_id;
    }

    public Product(String nameProduct, double price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Category getCat_id() {
        return cat_id;
    }

    public void setCat_id(Category cat_id) {
        this.cat_id = cat_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", cat_id=" + cat_id +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                '}';
    }
}
