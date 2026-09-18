package model;

public class Attendance {

    private int id;
    private int studentId;
    private int subjectId;
    private String date;
    private boolean present;

    public Attendance(int id, int studentId, int subjectId,
                      String date, boolean present) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.date = date;
        this.present = present;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getDate() {
        return date;
    }

    public boolean isPresent() {
        return present;
    }
}
