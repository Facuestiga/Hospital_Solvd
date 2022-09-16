package com.solvd.hospital.model;

public class Prescription {
    private int id;
    private String details;
    private int patientId;
    private int doctorId;
    private int medicalHistoryId;

    public Prescription(){}

    public Prescription(int id, String details, int patientId, int doctorId, int medicalHistoryId) {
        this.id = id;
        this.details = details;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.medicalHistoryId = medicalHistoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(int medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", medicalHistoryId=" + medicalHistoryId +
                '}';
    }
}
