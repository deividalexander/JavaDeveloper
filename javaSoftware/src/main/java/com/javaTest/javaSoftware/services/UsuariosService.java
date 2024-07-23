package com.javaTest.javaSoftware.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.javaTest.javaSoftware.interfaces.DataProcessor;
import com.javaTest.javaSoftware.interfaces.UserReview;
import com.javaTest.javaSoftware.models.Employee;
import com.javaTest.javaSoftware.models.EmployeeToExpose;
import com.javaTest.javaSoftware.models.ResponseEmployee;
import org.springframework.stereotype.Service;

import org.springframework.http.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosService implements UserReview {

    public UsuariosService() {
    }

    @Override
    public Object findByIdExactly(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(null,headers);
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dummy.restapiexample.com/api/v1/employee/"+id;
        ResponseEntity<String> responseService = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                String.class
        );


        HttpStatus statusCode = (HttpStatus) responseService.getStatusCode();
        String responseBody = responseService.getBody();

        System.out.println("Código de estado: " + statusCode);
        Gson g = new Gson();
        ResponseEmployee respuesta = g.fromJson(responseBody, ResponseEmployee.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(respuesta);
        System.out.println(json);

        ResponseEmployee<Employee> respuestaVerify = g.fromJson(responseBody, new TypeToken<ResponseEmployee<Employee>>(){}.getType());
        DataProcessor<?> dataProvider = DataFactory.reviewDataProvider(respuestaVerify.getData());


        return dtoReviewResponse(dataProvider);
    }

    @Override
    public Object findAllEmpoyee() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(null,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseService = restTemplate.exchange(
                "https://dummy.restapiexample.com/api/v1/employees",
                HttpMethod.GET,
                request,
                String.class
        );

        //HttpStatus statusCode = responseService.getStatusCode();

        HttpStatus statusCode = (HttpStatus) responseService.getStatusCode();
        String responseBody = responseService.getBody();

        System.out.println("Código de estado: " + statusCode);
        Gson g = new Gson();
        ResponseEmployee respuesta = g.fromJson(responseBody, ResponseEmployee.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(respuesta);
        System.out.println(json);

        ResponseEmployee<List<Employee>> respuestaVerify = g.fromJson(responseBody, new TypeToken<ResponseEmployee<List<Employee>>>(){}.getType());
        DataProcessor<?> dataProvider = DataFactory.reviewDataProvider(respuestaVerify.getData());


        return dtoReviewResponse(dataProvider);
    }

    public Object dtoReviewResponse(DataProcessor<?> dataProvider){
        Object result;
        if (dataProvider instanceof EmployeeReview) {

            Employee employee = ((EmployeeReview) dataProvider).getData();
            EmployeeToExpose transform = new EmployeeToExpose(
                    employee.getId().longValue(),
                    employee.getEmployee_name(),
                    employee.getEmployee_salary()*12,
                    employee.getEmployee_age().longValue(),
                    employee.getProfile_image()
            );
            System.out.println(employee.getEmployee_name());
            System.out.println(employee.getEmployee_salary());
            result = transform;
        } else if (dataProvider instanceof EmployeeListReview) {

            List<Employee> employeesFromService = ((EmployeeListReview) dataProvider).getData();
            List<EmployeeToExpose> employeeDTO = new ArrayList<>();
            System.out.println("El resultado de empleados lista es");
            for (Employee employee: employeesFromService) {
                System.out.println(employee.getEmployee_name());
                EmployeeToExpose transform = new EmployeeToExpose(
                        employee.getId().longValue(),
                        employee.getEmployee_name(),
                        employee.getEmployee_salary()*12,
                        employee.getEmployee_age().longValue(),
                        employee.getProfile_image()
                );
                employeeDTO.add(transform);
            }
            for (EmployeeToExpose empleado: employeeDTO) {
                System.out.println(empleado.getName());
                System.out.println(empleado.getEmployee_anual_salary());
            }
            result = employeeDTO;
        } else {
            throw new IllegalArgumentException("Tipo de dato no soportado en el DataProvider.");
        }
        return result;
    }

}
