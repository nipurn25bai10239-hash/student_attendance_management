package database;

import model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SubjectDAO {

    public boolean addSubject(Subject subject) {

        String sql = "INSERT INTO subjects (name) VALUES (?)";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, subject.getName());

            statement.executeUpdate();

            statement.close();
            connection.close();

            return true;

        } catch (Exception e) {
            System.out.println("Error adding subject: " + e.getMessage());
            return false;
        }
    }
}
