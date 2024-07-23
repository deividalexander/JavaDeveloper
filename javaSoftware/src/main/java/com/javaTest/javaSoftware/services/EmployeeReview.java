package com.javaTest.javaSoftware.services;

import com.javaTest.javaSoftware.interfaces.DataProcessor;
import com.javaTest.javaSoftware.models.Employee;

public class EmployeeReview implements DataProcessor<Employee> {

    private final Employee employee;

    public EmployeeReview(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Employee getData() {
        return employee;
    }
}
