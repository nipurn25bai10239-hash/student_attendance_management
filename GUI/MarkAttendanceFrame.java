package gui;

import database.AttendanceDAO;
import model.Attendance;

import javax.swing.*;
import java.awt.*;

public class MarkAttendanceFrame extends JFrame {

    private JTextField studentIdField;
    private JTextField subjectIdField;
    private JTextField dateField;

    private JRadioButton presentButton;
    private JRadioButton absentButton;

    public MarkAttendanceFrame() {

        setTitle("Mark Attendance");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        panel.add(studentIdField);

        panel.add(new JLabel("Subject ID:"));
        subjectIdField = new JTextField();
        panel.add(subjectIdField);

        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        panel.add(dateField);

        panel.add(new JLabel("Attendance:"));

        JPanel attendancePanel = new JPanel();

        presentButton = new JRadioButton("Present");
        absentButton = new JRadioButton("Absent");

        ButtonGroup group = new ButtonGroup();
        group.add(presentButton);
        group.add(absentButton);

        attendancePanel.add(presentButton);
        attendancePanel.add(absentButton);

        panel.add(attendancePanel);

        JButton markButton = new JButton("Mark Attendance");
        JButton closeButton = new JButton("Close");

        panel.add(markButton);
        panel.add(closeButton);

        add(panel);

        markButton.addActionListener(e -> markAttendance());

        closeButton.addActionListener(e -> dispose());
    }

    private void markAttendance() {

        String studentIdText = studentIdField.getText();
        String subjectIdText = subjectIdField.getText();
        String date = dateField.getText();

        if (studentIdText.isEmpty() ||
                subjectIdText.isEmpty() ||
                date.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields."
            );

            return;
        }

        if (!presentButton.isSelected() &&
                !absentButton.isSelected()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select Present or Absent."
            );

            return;
        }

        try {

            int studentId = Integer.parseInt(studentIdText);
            int subjectId = Integer.parseInt(subjectIdText);

            boolean present = presentButton.isSelected();

            Attendance attendance = new Attendance(
                    0,
                    studentId,
                    subjectId,
                    date,
                    present
            );

            AttendanceDAO attendanceDAO = new AttendanceDAO();

            boolean success =
                    attendanceDAO.markAttendance(attendance);

            if (success) {

                JOptionPane.showMessageDialog(
                        this,
                        "Attendance marked successfully!"
                );

                studentIdField.setText("");
                subjectIdField.setText("");
                dateField.setText("");

                presentButton.setSelected(false);
                absentButton.setSelected(false);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Unable to mark attendance."
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student ID and Subject ID must be numbers."
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            MarkAttendanceFrame frame =
                    new MarkAttendanceFrame();

            frame.setVisible(true);
        });
    }
}
