package com.solvd.hospital.model;

public class WelfareWork {
    private Long id;
    private String name;
    private long patientsId;

    public WelfareWork(){}

    public WelfareWork(Long id, String name, long patientsId) {
        this.id = id;
        this.name = name;
        this.patientsId = patientsId;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPatientsId() {
        return patientsId;
    }

    public void setPatientsId(long patientsId) {
        this.patientsId = patientsId;
    }

    @Override
    public String toString() {
        return "WelfareWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", patientsId=" + patientsId +
                '}';
    }
}
