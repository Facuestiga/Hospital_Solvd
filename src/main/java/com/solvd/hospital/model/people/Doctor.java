package com.solvd.hospital.model.people;

import com.solvd.hospital.dao.daoInterfaces.IBaseDAO;

import java.util.Objects;

public class Doctor extends User implements IBaseDAO <Doctor>{
    static long userId;
    private String registrationNumber;
    private long welfareWork;
    private long specialties;



    public Doctor(long userId, String name, String lastName, String email, String address, String phone, String password, String registrationNumber, long welfareWork, long specialties) {
        super(name, lastName, email);
        this.registrationNumber = registrationNumber;
        this.welfareWork = welfareWork;
        this.specialties = specialties;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public long getWelfareWork() {
        return welfareWork;
    }

    public void setWelfareWork(long welfareWork) {
        this.welfareWork = welfareWork;
    }

    public long getSpecialties() {
        return specialties;
    }

    public void setSpecialties(long specialties) {
        this.specialties = specialties;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", welfareWork=" + welfareWork +
                ", specialties=" + specialties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return welfareWork == doctor.welfareWork && specialties == doctor.specialties && registrationNumber.equals(doctor.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), registrationNumber, welfareWork, specialties);
    }

    @Override
    public void create(Doctor object) {

    }

    @Override
    public Doctor getById(long id) {
        return null;
    }

    @Override
    public void update(Doctor object) {

    }

    @Override
    public void delete(long id) {

    }
}
