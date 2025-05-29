package com.krishna.service;

import com.krishna.dao.EmployeeRepository;
import com.krishna.dto.EmployeeRequest;
import com.krishna.dto.EmployeeResponse;
import com.krishna.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(EmployeeRequest employeeRequest) {

        Employee employee = Employee.builder()
                .name(employeeRequest.getName())
                .build();

        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeResponse> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return getEmployeeResponse(employeeList);
    }

    List<EmployeeResponse> getEmployeeResponse(List<Employee> employees) {
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for (Employee emp : employees) {
            EmployeeResponse employeeResponse = EmployeeResponse.builder().empId(emp.getEmpId()).name(emp.getName()).build();
            employeeResponses.add(employeeResponse);

        }
        return employeeResponses;
    }


}
