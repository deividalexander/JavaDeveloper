package com.javaTest.javaSoftware.models;

import java.io.Serial;
import java.io.Serializable;

public class EmployeeToExpose implements Serializable {
    @Serial
    private static final long serialVersionUID = 2616895079721201610L;
    private Long id; //": 22,
    private String name; //": "Yuri Berry",
    private Double employee_anual_salary ; //": 675000,
    private Long employee_age; //": 40,
    private String profile_image; //": ""

    public EmployeeToExpose(Long id, String name, Double employee_anual_salary, Long employee_age, String profile_image) {
        this.id = id;
        this.name = name;
        this.employee_anual_salary = employee_anual_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public Long getId() {
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

    public Double getEmployee_anual_salary() {
        return employee_anual_salary;
    }

    public void setEmployee_anual_salary(Double employee_anual_salary) {
        this.employee_anual_salary = employee_anual_salary;
    }

    public Long getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Long employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}
