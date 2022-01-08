package com.bridgelabz.jdbc.model;

import java.sql.Date;

public class EmployeeInfo {
    private int id;
    private String name;
    private char gender;
    private Date startDate;
    private String address;
    private String phone_number;
    private String basic_pay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBasic_pay() {
        return basic_pay;
    }

    public void setBasic_pay(String basic_pay) {
        this.basic_pay = basic_pay;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", startDate=" + startDate +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", basic_pay='" + basic_pay + '\'' +
                '}';
    }
}
