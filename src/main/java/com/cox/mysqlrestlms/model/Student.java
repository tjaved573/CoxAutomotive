package com.cox.mysqlrestlms.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Student {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="studentId", updatable=false, nullable=false)
    private int studentId;

    @Column (name = "studentName", nullable = false)
    @NotBlank(message = "StudentName is mandatory")
    private String studentName;

    @Column(name = "studentEmail", nullable = false)
    @NotBlank(message = "StudentEmail is mandatory")
    private String studentEmail;

    public Student() {

    }

    public Student(int studentId, @NotNull String studentName, @NotNull String studentEmail) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}
