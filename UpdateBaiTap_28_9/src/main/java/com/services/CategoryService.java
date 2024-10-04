package com.services;

import com.connection.DatabaseConnection;
import com.model.Category;
import com.repository.CategoryRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements CategoryRepo{
    @Override
    public void inserCategory(Category category) {
        String query = "INSERT INTO category (nameCategory) VALUES ( ?);";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, category.getNameCategory());
            preparedStatement.executeUpdate();
            System.out.println("thêm thành công!!");
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }


    @Override
    public Category findCategoryById(int id) {
        String query = "select * from category where id=?;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id );
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                id = rs.getInt("id");
                String nameCategory = rs.getString("nameCategory");
                System.out.println(id + ", name-- " + nameCategory);
                return category;
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
        return null;
    }


    @Override
    public List<Category> findCategoryByName(String nameCategory) {
        List<Category> categoryList = new ArrayList<>();
        String query = "select * from Category where nameCategory like ?;";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setNString(1, "%"+nameCategory+"%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                int cat_id = rs.getInt("id");
                String name_cat = rs.getString("nameCategory");
                category.setId(cat_id);
                category.setNameCategory(name_cat);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
        return categoryList;

    }

    @Override
    public boolean checkCategory(String name) {
        List<Category> categoryList = new ArrayList<>();
        String query = "select * from category where nameCategory like ? ";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setNString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                int id = rs.getInt("id");
                String nameCate = rs.getString("nameCategory");
                category.setId(id);
                category.setNameCategory(nameCate);
                return true;
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
        return false;
    }
}
