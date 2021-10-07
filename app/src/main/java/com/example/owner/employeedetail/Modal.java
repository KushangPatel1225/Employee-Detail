package com.example.owner.employeedetail;

/**
 * Created by owner on 10/6/2021.
 */

public class Modal {

    String first_name, last_name, designation, email, date_of_birth, address, department;

    public Modal(String first_name, String last_name, String designation, String email, String date_of_birth, String address, String department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.designation = designation;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.department = department;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}



