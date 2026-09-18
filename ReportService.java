package service;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportService {

    public String getAttendanceReport(int studentId, int subjectId) {

        String sql = """
                SELECT COUNT(*) AS total,
                       SUM(CASE WHEN present = TRUE THEN 1 ELSE 0 END) AS attended
                FROM attendance
                WHERE student_id = ? AND subject_id = ?
                """;

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, studentId);
            statement.setInt(2, subjectId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                int total = result.getInt("total");
                int attended = result.getInt("attended");

                if (total == 0) {

                    result.close();
                    statement.close();
                    connection.close();

                    return "No attendance records found.";
                }

                double percentage =
                        (attended * 100.0) / total;

                String status;

                if (percentage < 75) {
                    status = "WARNING: Attendance is below 75%.";
                } else {
                    status = "Attendance requirement satisfied.";
                }

                result.close();
                statement.close();
                connection.close();

                return "Attendance Report\n\n"
                        + "Student ID: " + studentId + "\n"
                        + "Subject ID: " + subjectId + "\n\n"
                        + "Total Classes: " + total + "\n"
                        + "Classes Attended: " + attended + "\n"
                        + "Attendance: "
                        + String.format("%.2f", percentage)
                        + "%\n\n"
                        + "Status: " + status;
            }

            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

            return "Error generating attendance report.";
        }

        return "Unable to generate report.";
    }
}