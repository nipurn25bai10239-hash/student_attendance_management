package gui;

import database.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class StudentManagementFrame extends JFrame {

    private JTextField nameField;
    private JTextField regField;
    private JTextField emailField;

    public StudentManagementFrame() {

        setTitle("Student Management");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Registration No:"));
        regField = new JTextField();
        panel.add(regField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        JButton addButton = new JButton("Add Student");
        panel.add(addButton);

        JButton closeButton = new JButton("Close");
        panel.add(closeButton);

        add(panel);

        addButton.addActionListener(e -> addStudent());
        closeButton.addActionListener(e -> dispose());
    }

    private void addStudent() {

        String name = nameField.getText();
        String registrationNo = regField.getText();
        String email = emailField.getText();

        if (name.isEmpty() || registrationNo.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Name and Registration Number are required."
            );

            return;
        }

        Student student = new Student(
                0,
                name,
                registrationNo,
                email
        );

        StudentDAO studentDAO = new StudentDAO();

        if (studentDAO.addStudent(student)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student added successfully!"
            );

            nameField.setText("");
            regField.setText("");
            emailField.setText("");

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to add student."
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            StudentManagementFrame frame =
                    new StudentManagementFrame();

            frame.setVisible(true);
        });
    }
}