package gui;

import service.ReportService;

import javax.swing.*;
import java.awt.*;

public class AttendanceReportFrame extends JFrame {

    private JTextField studentIdField;
    private JTextField subjectIdField;

    public AttendanceReportFrame() {

        setTitle("Attendance Report");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel =
                new JPanel(new GridLayout(3, 2, 10, 10));

        inputPanel.add(new JLabel("Student ID:"));

        studentIdField = new JTextField();
        inputPanel.add(studentIdField);

        inputPanel.add(new JLabel("Subject ID:"));

        subjectIdField = new JTextField();
        inputPanel.add(subjectIdField);

        JButton reportButton =
                new JButton("Generate Report");

        JButton closeButton =
                new JButton("Close");

        inputPanel.add(reportButton);
        inputPanel.add(closeButton);

        JTextArea resultArea =
                new JTextArea();

        resultArea.setEditable(false);
        resultArea.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea),
                BorderLayout.CENTER);

        reportButton.addActionListener(e -> {

            String studentText =
                    studentIdField.getText();

            String subjectText =
                    subjectIdField.getText();

            if (studentText.isEmpty() ||
                    subjectText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter Student ID and Subject ID."
                );

                return;
            }

            try {

                int studentId =
                        Integer.parseInt(studentText);

                int subjectId =
                        Integer.parseInt(subjectText);

                ReportService reportService =
                        new ReportService();

                String report =
                        reportService.getAttendanceReport(
                                studentId,
                                subjectId
                        );

                resultArea.setText(report);

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student ID and Subject ID must be numbers."
                );
            }
        });

        closeButton.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AttendanceReportFrame frame =
                    new AttendanceReportFrame();

            frame.setVisible(true);
        });
    }
}