package gui;

import javax.swing.*;
import java.awt.*;

public class AttendanceFrame extends JFrame {

    public AttendanceFrame() {

        setTitle("Student Attendance Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel(
                "Student Attendance Management System",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));

        JButton studentButton =
                new JButton("Student Management");

        JButton attendanceButton =
                new JButton("Mark Attendance");

        JButton reportButton =
                new JButton("Attendance Report");

        JButton exitButton =
                new JButton("Exit");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        panel.add(studentButton);
        panel.add(attendanceButton);
        panel.add(reportButton);
        panel.add(exitButton);

        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        // Student Management
        studentButton.addActionListener(e -> {
            StudentManagementFrame frame =
                    new StudentManagementFrame();

            frame.setVisible(true);
        });

        // Mark Attendance
        attendanceButton.addActionListener(e -> {
            MarkAttendanceFrame frame =
                    new MarkAttendanceFrame();

            frame.setVisible(true);
        });

        // Attendance Report
        reportButton.addActionListener(e -> {
            AttendanceReportFrame frame =
                    new AttendanceReportFrame();

            frame.setVisible(true);
        });

        // Exit
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AttendanceFrame frame =
                    new AttendanceFrame();

            frame.setVisible(true);
        });
    }
}
