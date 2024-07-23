package com.javaTest.javaSoftware.models;

import java.io.Serial;
import java.io.Serializable;


public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 3856529473337093884L;
    private Double id; //": 22,
    private String employee_name; //": "Yuri Berry",
    private Double employee_salary; //": 675000,
    private Double employee_age; //": 40,
    private String profile_image; //": ""


    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Double getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Double employee_age) {
        this.employee_age = employee_age;
    }
}
