package com.services;


import com.connection.DatabaseConnection;
import com.model.Category;
import com.model.Product;
import com.repository.ProductRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements ProductRepo {


    @Override
    public boolean insertProduct(Product product) {
        String query = "INSERT INTO product (nameProduct,price,cat_id) VALUES (?, ?, ?);";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getCat_id().getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        Category category = new Category();
        String query = "UPDATE Product set  nameProduct = ?, price = ?,cat_id=? WHERE id = ?;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3,product.getCat_id().getId());
            preparedStatement.setInt(4,product.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        String query = "DELETE FROM Product WHERE id = ?;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
        return false;
    }

    @Override
    public void searchProductByNameCategory(String nameCategory) {
        String query = " select cat.nameCategory,pr.nameProduct,pr.price,pr.cat_id from Product pr inner join Category cat where cat.nameCategory like ? and pr.cat_id = cat.id;";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setNString(1, "%" + nameCategory + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nameCat = rs.getString("nameCategory");
                String name = rs.getString("nameProduct");
                double price = rs.getDouble("price");
                int cat_id = rs.getInt("cat_id");
                System.out.println(nameCat + " ,name-- " + name + " ,giá-- " + price + " ,cat_id--" + cat_id);
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }

    @Override
    public void findNameProduct(String name) {
        List<Product> listPro = new ArrayList<>();
        String query = " select* from product ;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameProduct = rs.getString("nameProduct");
                double price = rs.getDouble("price");
                int Cat_id = rs.getInt("Cat_id");
                System.out.println(id + " ,name-- " + nameProduct + ",giá-- " + price + " ,cat_id--" + Cat_id);
                Product pro = new Product();
                listPro.add(pro);
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }

    @Override
    public void SortAsc() {
        List<Product> listPro = new ArrayList<>();
        String query = " select* from product order by price asc;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameProduct = rs.getString("nameProduct");
                double price = rs.getDouble("price");
                int Cat_id = rs.getInt("Cat_id");
                System.out.println(id + " ,name-- " + nameProduct + ",giá-- " + price + " ,cat_id--" + Cat_id);
                Product pro = new Product();
                listPro.add(pro);
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }

    @Override
    public void SortDesc() {
        List<Product> listPro = new ArrayList<>();
        String query = " select* from product order by price desc;";
        try (Connection connection = DatabaseConnection.getConnection();
             // Creating a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Executing the query and getting the result set
            ResultSet rs = preparedStatement.executeQuery();
            // Processing the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameProduct = rs.getString("nameProduct");
                double price = rs.getDouble("price");
                int Cat_id = rs.getInt("Cat_id");
                System.out.println(id + " ,name-- " + nameProduct + ",giá-- " + price + " ,cat_id--" + Cat_id);
                Product pro = new Product();
                listPro.add(pro);
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }
}
