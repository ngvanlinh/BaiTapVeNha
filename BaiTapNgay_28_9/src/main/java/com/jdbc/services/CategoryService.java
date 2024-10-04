package jdbc.services;

import org.jdbc.connection.DatabaseConnection;
import org.jdbc.model.Category;
import org.jdbc.repository.CategoryRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryService implements CategoryRepo {
    @Override
    public void inserCategory(Category category) {
        String query = "INSERT INTO category (id,nameCategory) VALUES (?, ?);";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getNameCategory());
            preparedStatement.executeUpdate();
            System.out.println("thêm thành công!!");
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }

    @Override
    public void searchCategoryById(int id) {
        String query = "select* from category where id = ?;";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                String nameCategory = rs.getString("nameCategory");
                System.out.println(id + ", name-- " + nameCategory);
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }

    @Override
    public void searchCategoryByName(String name) {
        String query = "select * from category where nameCategory like ? ";
        System.out.println(query);

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setNString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameCategory = rs.getString("nameCategory");
                System.out.println(id + ", name-- " + nameCategory);
            }
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
    }
}
