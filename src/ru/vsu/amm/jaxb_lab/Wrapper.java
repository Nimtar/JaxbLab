package ru.vsu.amm.jaxb_lab;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Wrapper {
    private ArrayList<Student> students;

    public ArrayList<Student> getStudents() {
        return students;
    }

    @XmlElement
    public Wrapper setStudents(ArrayList<Student> students) {
        this.students = students;
        return this;
    }

    public Wrapper delete(int index) {
        this.students.remove(index);
        return this;
    }

    public Wrapper add(Student student) {
        this.students.add(student);
        return this;
    }

    public Wrapper edit(int index, Student student) {
        this.students.add(index, student);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i=0; i<students.size(); i++) {
            s.append(i).append(": ").append(students.get(i).toString()).append("\n");
        }
        return s.toString();
    }
}
