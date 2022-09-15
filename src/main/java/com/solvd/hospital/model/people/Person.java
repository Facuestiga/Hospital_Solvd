package com.solvd.hospital.model.people;

import java.util.Objects;

public class Person {
    private String name;
    private String lastName;
    private int dni;
    private String phone;
    private String address;
    private String pathology;
    private double weight;
    private double height;
    private int age;

    public Person(){

    }

    public Person(String name, String lastName, int dni, String phone, String address, String pathology, double weight, double height, int age) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.phone = phone;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }



    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPathology() {
        return pathology;
    }

    public void setPathology(String pathology) {
        this.pathology = pathology;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni=" + dni +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", pathology='" + pathology + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return dni == person.dni && Double.compare(person.weight, weight) == 0 && Double.compare(person.height, height) == 0 && age == person.age && Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName) && Objects.equals(phone, person.phone) && Objects.equals(address, person.address) && Objects.equals(pathology, person.pathology);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, dni, phone, address, pathology, weight, height, age);
    }


}
