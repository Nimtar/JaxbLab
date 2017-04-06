package ru.vsu.amm.jaxb_lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Wrapper wrapper = getWrapper();

    public static void main(String[] args) {
        StudentsMarshaller studentsMarshaller = new StudentsMarshaller();
        studentsMarshaller.marshall(wrapper);
        Object students1 = studentsMarshaller.unmarshall();
        System.out.println(students1);
        String action = getAction();
        while (!action.equals("q")) {
            Student student = null;
            int index = -1;
            if (action.equals("a") || (action.equals("e"))) {
                student = getStudent();
            }
            if (action.equals("d") || action.equals("e")) {
                index = getIndex();
            }
            if (action.equals("d")) {
                wrapper.delete(index);
            }
            if (action.equals("a")) {
                wrapper.add(student);
            }
            if (action.equals("e")) {
                wrapper.edit(index, student);
            }
            studentsMarshaller.marshall(wrapper);
            students1 = studentsMarshaller.unmarshall();
            System.out.println(students1);
            action = getAction();
        }

    }

    private static boolean isNotValid(String action) {
        return !(action.equals("e") || action.equals("d") || action.equals("a"));
    }

    private static Wrapper getWrapper() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student01 = new Student("Mitya", 21, 4, "phipsy", 973516);
        Student student02 = new Student("Ilyusha", 20, 4, "amm", 873516);
        Student student03 = new Student("Nikita", 21, 4, "amm", 873515);
        studentList.add(student01);
        studentList.add(student02);
        studentList.add(student03);
        return new Wrapper().setStudents(studentList);
    }

    private static int getIndex() {
        System.out.println("Write down student's index");
        int index = scanner.nextInt();
        if (index < 0 || index > wrapper.getStudents().size()) {
            System.out.println("NOO..");
            index = getIndex();
        }
        return index;
    }

    private static Student getStudent() {
        System.out.println("Write down information about student. 1) Student's name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("2) Student's age: ");
        int age = scanner.nextInt();
        System.out.println("3) Student's year of studying: ");
        int year = scanner.nextInt();
        System.out.println("4) Student's faculty: ");
        String faculty = scanner.next();
        System.out.println("5) Student's id: ");
        int id = scanner.nextInt();
        return new Student(name, age, year, faculty, id);
    }

    private static String getAction() {
        System.out.println("If you want to delete student press d, add - a, edit - e. " +
                "\nIf you don't want to do anything press q");
        String action = scanner.next();
        if (isNotValid(action)) {
            System.out.println("NO");
            getAction();
        }
        return action;
    }

}
