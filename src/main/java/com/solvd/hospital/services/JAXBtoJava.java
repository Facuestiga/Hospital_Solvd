package com.solvd.hospital.services;
import com.solvd.hospital.model.people.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.SQLException;
public class JAXBtoJava {
    private static Logger logger = LogManager.getLogger(JAXBtoJava.class);

    public static void main(String[] args) {

        try {

            Patient patient = new Patient();
            patient.setId(1);
            patient.setName("John");
            patient.setLastName("Williams");
            patient.setDni(12345678);
            patient.setAddress("Florida 534");
            patient.setWeight(62.7);
            patient.setHeight(1.75);
            patient.setDoctorId(1);
            patient.setRoomId(1);
            patient.setMedicineId(1);
            patient.setPhone("1546879635");
            patient.setAge(23);

            JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            File file = new File("src\\main\\resources\\Patient.xml");

            marshaller.marshal(patient, file);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
