package com.solvd.hospital.model;

public class Area {
    private long specialtyId;

    public Area(){}

    public Area(long specialtyId){
        this.specialtyId = specialtyId;
    }

    public long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(long specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Override
    public String toString() {
        return "Area{" +
                "specialtyId=" + specialtyId +
                '}';
    }
}
