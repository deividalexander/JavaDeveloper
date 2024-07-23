package com.javaTest.javaSoftware.services;

import com.javaTest.javaSoftware.interfaces.DataProcessor;
import com.javaTest.javaSoftware.models.Employee;

import java.util.List;

public class DataFactory {

    public static DataProcessor<?> reviewDataProvider(Object data){
        System.out.println("La entrada es:");
        System.out.println(data);
        if (data instanceof Employee){
                return new EmployeeReview((Employee) data);
            }else if(data instanceof List<?>){
                List<?> list = (List<?>) data;
                if (!list.isEmpty() && list.get(0) instanceof Employee) {
                    return new EmployeeListReview((List<Employee>) data);
                }
                System.out.println(list.get(0));
            }

        throw new IllegalArgumentException("Datos no soportados");
    }
}
