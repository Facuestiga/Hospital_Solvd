package com.solvd.hospital.model;

public class MedicalHistory {
    private long id;
    private String description;
    private String date;
    private long doctorId;
    private long patientId;

    public MedicalHistory(){}

    public MedicalHistory(long id, String description, String date, long doctorId, long patientId) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "MedicalHistory{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                '}';
    }
}
