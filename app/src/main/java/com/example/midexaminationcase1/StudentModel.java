package com.example.midexaminationcase1;

public class StudentModel {
    private int id;
    private String studentName;
    private String studentId;
    private String major;


    public StudentModel(String studentName, String studentId, String major) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.major = major;
    }


    public StudentModel(int id, String studentName, String studentId, String major) {
        this.id = id;
        this.studentName = studentName;
        this.studentId = studentId;
        this.major = major;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
}
