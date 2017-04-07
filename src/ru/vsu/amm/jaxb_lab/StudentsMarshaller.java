package ru.vsu.amm.jaxb_lab;

import javax.xml.bind.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class StudentsMarshaller {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;


    public StudentsMarshaller() {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            this.setMarshaller(context.createMarshaller());
            this.setUnmarshaller(context.createUnmarshaller());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public StudentsMarshaller setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        return this;
    }

    public StudentsMarshaller setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
        return this;
    }

    public void marshall(Wrapper wrapper) {
        try {
            marshaller.marshal(wrapper, new FileOutputStream("/home/nimtar/JavaLab/resourse.xml"));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Wrapper unmarshall() {
        try {
            return (Wrapper) unmarshaller.unmarshal(new FileInputStream("/home/nimtar/JavaLab/resourse.xml"));
        } catch (JAXBException | FileNotFoundException e) {
            System.out.println("Don't worry, but file is corrupted and will be cleared");
            marshall(new Wrapper());
        }
        return null;
    }
}
