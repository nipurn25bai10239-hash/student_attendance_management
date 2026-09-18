package database;

import model.Attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AttendanceDAO {

    public boolean markAttendance(Attendance attendance) {

        String sql = "INSERT INTO attendance " +
                "(student_id, subject_id, date, present) " +
                "VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, attendance.getStudentId());
            statement.setInt(2, attendance.getSubjectId());
            statement.setString(3, attendance.getDate());
            statement.setBoolean(4, attendance.isPresent());

            statement.executeUpdate();

            statement.close();
            connection.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
