package model;

public class Student {

    private int id;
    private String name;
    private String registrationNo;
    private String email;

    public Student(int id, String name, String registrationNo, String email) {
        this.id = id;
        this.name = name;
        this.registrationNo = registrationNo;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getEmail() {
        return email;
    }
}
