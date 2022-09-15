package com.solvd.hospital.model;

public class DoctorLicenses {
    private long id;
    private String number;
    private String expDate;
    private long doctorId;

    public DoctorLicenses(){}

    public DoctorLicenses(long id, String number, String expDate, long doctorId) {
        this.id = id;
        this.number = number;
        this.expDate = expDate;
        this.doctorId = doctorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "DoctorLicenses{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", expDate='" + expDate + '\'' +
                ", doctorId=" + doctorId +
                '}';
    }
}
