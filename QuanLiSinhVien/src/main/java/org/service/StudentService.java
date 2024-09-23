package org.service;

import org.connection.ConnecSQL;
import org.model.Student;
import org.repository.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentRepository {

    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM student;";
    @Override
    public void insertStudent(Student student) {
        String query = "INSERT INTO student (id,nameStudent,address) VALUES (?, ?, ?);";
        try (Connection connection = ConnecSQL.getConnection();
             // Creating a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Setting parameters
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getNameStudent());
            preparedStatement.setString(3, student.getAddress());

            // Executing the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ConnecSQL.printSQLException(e);
        }
    }

    @Override
    public void selectStudent() {

        List<Student> students = new ArrayList<>();
        try (Connection connection = ConnecSQL.getConnection();
             // Creating a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            // Executing the query and getting the result set
            ResultSet rs = preparedStatement.executeQuery();
            // Processing the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameStudent = rs.getString("nameStudent");
                String address = rs.getString("address");
                System.out.println(id + ", name-- " + nameStudent + ", dia chi-- " + address );
                Student std = new Student(id,nameStudent,address);
                students.add(std);
            }
        } catch (SQLException e) {
            ConnecSQL.printSQLException(e);
        }
    }

    @Override
    public void updateStudent(Student student, int id) {
        String query = "UPDATE student set  nameStudent = ?, address = ? WHERE id = ?;";
        // Establishing a Connection
        try (Connection connection = ConnecSQL.getConnection();
             // Creating a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Setting parameters
            preparedStatement.setString(1, student.getNameStudent());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setInt(3, id); // Updating record with the provided ID
            // Executing the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ConnecSQL.printSQLException(e);
        }
    }

    @Override
    public void deleteStudent(int id) {
        String query = "DELETE FROM student WHERE id = ?;";
        // Establishing a Connection
        try (Connection connection = ConnecSQL.getConnection();
             // Creating a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Setting parameter
            preparedStatement.setInt(1, id); // Deleting record with the provided ID
            // Executing the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ConnecSQL.printSQLException(e);
        }
    }
}
