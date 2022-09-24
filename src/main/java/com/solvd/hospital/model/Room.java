package com.solvd.hospital.model;

import com.solvd.hospital.model.people.Patient;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private long id;
    private String description;
    private long areaId;

    private List<Patient> patientList;

    public Room(){}

    public Room(long id, String description, long areaId) {
        this.id = id;
        this.description = description;
        this.areaId = areaId;
        this.patientList = new ArrayList<>();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public long getAreaId() {
        return areaId;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public void addPatient(Patient p){
        this.patientList.add(p);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", areaId=" + areaId +
                '}';
    }
}
