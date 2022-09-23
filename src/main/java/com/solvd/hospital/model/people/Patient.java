package com.solvd.hospital.model.people;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Patient extends Person {


    private Long id;
    private String pathology;
    private long roomId;
    private long doctorId;
    private int medicineId;

    public Patient(){}

    public Patient(Long id, String pathology, long roomId, long doctorId, int medicineId) {
        this.id = id;
        this.pathology = pathology;
        this.roomId = roomId;
        this.doctorId = doctorId;
        this.medicineId = medicineId;
    }

    public Patient(String name, String lastName) {
        super();
        this.id = id;
        this.pathology = pathology;
        this.roomId = roomId;
        this.doctorId = doctorId;
        this.medicineId = medicineId;
    }

    @XmlTransient //skip field when parser to xml
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPathology() {
        return pathology;
    }

    public void setPathology(String pathology) {
        this.pathology = pathology;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", pathology='" + pathology + '\'' +
                ", roomId=" + roomId +
                ", doctorId=" + doctorId +
                ", medicineId=" + medicineId +
                '}';
    }
}

