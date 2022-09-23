package com.solvd.hospital.model;

public class Ambulance {
    private Long id;
    private String make;
    private String model;
    private long driverId;
    private long patientId;

    public Ambulance(){}

    public Ambulance(Long id, String make, String model, long driverId, long patientId) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.driverId = driverId;
        this.patientId = patientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Ambulance{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", driverId=" + driverId +
                ", patientId=" + patientId +
                '}';
    }
}
