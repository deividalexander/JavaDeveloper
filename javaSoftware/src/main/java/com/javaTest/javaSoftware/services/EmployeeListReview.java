package com.javaTest.javaSoftware.services;

import com.javaTest.javaSoftware.interfaces.DataProcessor;
import com.javaTest.javaSoftware.models.Employee;

import java.util.List;

public class EmployeeListReview implements DataProcessor<List<Employee>> {

    private final List<Employee> employees;

    public EmployeeListReview(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> getData() {
        return employees;
    }
}
