package com.solvd.hospital.jaxb;

import java.io.StringReader;

import com.solvd.hospital.model.Medicine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlToJava {

    private static Logger logger = LogManager.getLogger(XmlToJava.class);
    public static void main(String[] args) {

        try{
            String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                    "<Medicine id = \"1\">\n" +
                    "    <name>Ibuprofen</name>\n" +
                    "    <description>A drug used to treat fever, swelling, pain, and redness by preventing the body from making a substance that causes inflammation. </description>\n" +
                    "</Medicine>";
            //first read the xml file from the location
            //File file = new File ("src\\main\\resources\\Medicine.xml");

            //instance JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Medicine.class);

            //instance interface Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Medicine medicine = (Medicine) unmarshaller.unmarshal(new StringReader(xmlStr)); //return a object. I must caste de to my object
            logger.info(medicine.getId()+ "\n" +medicine.getName() + "\n", medicine.getDescription());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
