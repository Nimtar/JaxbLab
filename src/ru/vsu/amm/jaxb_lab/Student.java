package ru.vsu.amm.jaxb_lab;

import javax.xml.bind.annotation.XmlElement;


public class Student {
    private String name;
    private int age;
    private int year;
    private String faculty;
    private int studentID;

    public Student() {
    }

    public Student(String name, int age, int year, String faculty, int studentID) {
        this.name = name;
        this.age = age;
        this.year = year;
        this.faculty = faculty;
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return name + ", " + age + " years old, " + year
                + " studying year. Faculty: " + faculty + ". StudentID: " + studentID;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public int getYear() {
        return year;
    }

    @XmlElement
    public Student setYear(int year) {
        this.year = year;
        return this;
    }

    public String getFaculty() {
        return faculty;
    }

    @XmlElement
    public Student setFaculty(String faculty) {
        this.faculty = faculty;
        return this;
    }

    public int getStudentID() {
        return studentID;
    }

    @XmlElement
    public Student setStudentID(int studentID) {
        this.studentID = studentID;
        return this;
    }
}
