package database;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public boolean addStudent(Student student) {

        String sql = "INSERT INTO students (name, registration_no, email) VALUES (?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getRegistrationNo());
            statement.setString(3, student.getEmail());

            statement.executeUpdate();

            statement.close();
            connection.close();

            return true;

        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
            return false;
        }
    }
}