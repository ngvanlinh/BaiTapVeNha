package org.jdbc.model;

public class Product {
    private int id,cat_id;
    private String nameProduct;
    private double price;

    public Product(int id,  String nameProduct,double price, int cat_id) {
        this.id = id;
        this.price = price;
        this.nameProduct = nameProduct;
        this.cat_id = cat_id;
    }

    public Product() {
    }

    public Product(String nameProduct, double price, int cat_id) {
        this.price = price;
        this.nameProduct = nameProduct;
        this.cat_id = cat_id;
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

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
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
