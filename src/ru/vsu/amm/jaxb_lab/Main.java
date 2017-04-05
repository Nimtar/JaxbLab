package ru.vsu.amm.jaxb_lab;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Student> studentList = new ArrayList<>();
            Student student01 = new Student("Mitya", 21, 4, "phipsy", 973516);
            Student student02 = new Student("Ilyusha", 20, 4, "amm", 873516);
            Student student03 = new Student("Nikita", 21, 4, "amm", 873515);
            studentList.add(student01);
            studentList.add(student02);
            studentList.add(student03);
            Wrapper wrapper = new Wrapper();
            wrapper.setStudents(studentList);
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new FileOutputStream("/home/nimtar/JavaLab/resourse.xml"));
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object student1 = unmarshaller.unmarshal(new FileInputStream("/home/nimtar/JavaLab/resourse.xml"));
            System.out.println(student1);
            String action = getAction();
            while (!(action.equals("e") || action.equals("d") || action.equals("a"))) {
                System.out.println("NO");
                action = getAction();
            }
            int index = getIndex();
            while (index < 0 || index > wrapper.getStudents().size()) {
                System.out.println("NOO..");
                index = getIndex();
            }
            if (action.equals("d")) {
                wrapper.delete(index);
            }


        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int getIndex() {
        System.out.println("Write down student's index");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        return index;
    }

    private static String getAction() {
        System.out.println("If you want to delete student press d, add - a, edit - e");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.next();
        return action;
    }

}
