# Project Statement

## 1. Project Title

**Student Attendance Management System**

---

## 2. Student Details

- **Name:** NIPURN NAGPURI
- **Registration Number:** 25BAI10239
- **Course:** Programming in Java
- **Faculty Name:** S. Muthusundari
- **University:** VIT Bhopal University
- **Project Type:** Build Your Own Project

---

## 3. Project Overview

The Student Attendance Management System is a Java-based desktop application developed to manage student attendance records in a simple and organized manner.

The application uses Java Swing for the graphical user interface and MySQL for storing student, subject, and attendance information. JDBC is used to establish communication between the Java application and the MySQL database.

The system provides modules for student management, attendance recording, and attendance reporting.

---

## 4. Problem Statement

Managing attendance manually can be time-consuming and may result in data-entry errors. Calculating attendance percentages manually can also require additional effort.

The proposed system provides a computerized solution where student details and attendance records can be stored in a database. It also calculates attendance percentage and provides a warning when attendance falls below 75%.

---

## 5. Objectives

The main objectives of the project are:

1. To create a simple desktop-based attendance management system.
2. To store student information in a structured database.
3. To record attendance for different students and subjects.
4. To calculate attendance percentage automatically.
5. To provide a warning when attendance is below 75%.
6. To demonstrate Java programming concepts such as OOP, Swing, JDBC, exception handling, and modular programming.

---

## 6. Functional Requirements

### FR-01: Student Management

The system allows the user to enter and store:

- Student Name
- Registration Number
- Email

The system validates the required fields before storing the student record.

### FR-02: Attendance Management

The system allows the user to record attendance using:

- Student ID
- Subject ID
- Date
- Present/Absent status

The attendance information is stored in the MySQL database.

### FR-03: Attendance Reporting

The system retrieves attendance information for a selected student and subject and calculates:

- Total Classes
- Classes Attended
- Attendance Percentage

### FR-04: Attendance Warning

The system checks the calculated attendance percentage.

If attendance is below 75%, the system displays a warning message. Otherwise, it displays that the attendance requirement is satisfied.

---

## 7. Non-Functional Requirements

### Performance

The application performs basic database operations and generates attendance reports efficiently for the stored records.

### Reliability

Attendance and student information are stored in the MySQL database so that the records remain available after the application is closed.

### Input Validation and Error Handling

The application checks required fields and handles invalid numeric input and database-related errors.

### Maintainability

The project is divided into separate packages such as `model`, `database`, `service`, and `gui`, making the source code easier to understand and maintain.

### Usability

The Java Swing graphical interface provides separate screens for student management, attendance marking, and attendance reporting.

### Data Integrity

The database uses primary keys, unique constraints, and foreign keys to maintain relationships between students, subjects, and attendance records.

---

## 8. Technologies Used

- **Programming Language:** Java
- **GUI:** Java Swing
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **Database Driver:** MySQL Connector/J
- **IDE:** IntelliJ IDEA
- **Database Tool:** MySQL Workbench

---

## 9. Project Structure

```text
StudentAttendanceSystem
│
├── src
│   ├── Main.java
│   │
│   ├── model
│   │   ├── Student.java
│   │   ├── Subject.java
│   │   └── Attendance.java
│   │
│   ├── database
│   │   ├── DatabaseConnection.java
│   │   ├── StudentDAO.java
│   │   ├── SubjectDAO.java
│   │   └── AttendanceDAO.java
│   │
│   ├── service
│   │   └── ReportService.java
│   │
│   └── gui
│       ├── AttendanceFrame.java
│       ├── StudentManagementFrame.java
│       ├── MarkAttendanceFrame.java
│       └── AttendanceReportFrame.java
