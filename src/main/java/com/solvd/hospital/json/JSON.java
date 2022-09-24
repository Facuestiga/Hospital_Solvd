package com.solvd.hospital.json;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSON {
    public static void main(String[] args) {
        JSONObject patient = new JSONObject();
        patient.put("firstname", "Jason");
        patient.put("lastname", "Cox");
        patient.put("address", "Washinghto 500");
        patient.put("phone", "1122334455");
        patient.put("dni", 452654123);
        patient.put("age", 23);
        patient.put("weight", 70);
        patient.put("height", 1.73);
        patient.put("pathology", "pneumonia");

        JSONObject patientObj = new JSONObject();
        patientObj.put("patient", patient);

        JSONObject patient2 = new JSONObject();
        patient2.put("firstname", "George");
        patient2.put("lastname", "Williams");
        patient2.put("address", "Florida 600");
        patient2.put("phone", "1122336699");
        patient2.put("dni", 432654123);
        patient2.put("age", 25);
        patient2.put("weight", 72);
        patient2.put("height", 1.75);
        patient2.put("pathology", "gripe");

        JSONObject patientObj2 = new JSONObject();
        patientObj2.put("patient", patient2);

        JSONObject medicine = new JSONObject();
        medicine.put("name", "ibuprofen");
        medicine.put("description", "A drug used to treat fever, swelling, pain, " +
                "and redness by preventing the body from making a substance that causes inflammation");

        JSONObject medicineObj = new JSONObject();
        medicineObj.put("medicine", medicine);

        JSONObject medicine2 = new JSONObject();
        medicine.put("name", "paracetamol");
        medicine.put("description", " is a commonly used medicine that can " +
                "help treat pain and reduce a high temperature (fever).");
        JSONObject medicineObj2 = new JSONObject();
        medicineObj2.put("medicine", medicine2);

        JSONObject medicine3 = new JSONObject();
        medicine.put("name", "loratadine");
        medicine.put("description", "Loratadine is used to temporarily relieve the symptoms of hay fever " +
                "(allergy to pollen, dust, or other substances in the air) and other allergies" );

        JSONObject medicineObj3 = new JSONObject();
        medicineObj3.put("medicine", medicine3);

        JSONArray empList = new JSONArray();
        empList.add(patientObj);
        empList.add(patientObj2);
        empList.add(medicineObj);
        empList.add(medicineObj2);
        empList.add(medicineObj3);

        JSONArray medicineList = new JSONArray();
        medicineList.add(medicineObj);
        medicineList.add(medicineObj2);
        medicineList.add(medicineObj3);

        try(FileWriter file = new FileWriter("src//main//resources//json//Patient.json")){
            file.write(empList.toJSONString() + medicineList.toJSONString());
            file.flush();
        }
        catch(IOException e) {e.printStackTrace();}
    }

}
