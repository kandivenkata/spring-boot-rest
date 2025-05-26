package com.krishna.service;

import com.krishna.dao.EmployeeRepository;
import com.krishna.dto.EmployeeRequest;
import com.krishna.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
