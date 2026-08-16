package com.bridgelabz.model;

public class Student extends Person {

    private int id;
    private String course;
    private int marks;

    public Student() {
    }

    public Student(String name, String email, String course, int marks) {
        super(name, email);
        this.course = course;
        this.marks = marks;
    }

    public Student(int id, String name, String email, String course, int marks) {
        super(name, email);
        this.id = id;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", course='" + course + '\'' +
                ", marks=" + marks +
                '}';
    }
}