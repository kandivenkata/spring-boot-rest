package com.krishna.service;

import com.krishna.dto.EmployeeRequest;
import com.krishna.dto.EmployeeResponse;
import com.krishna.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(EmployeeRequest employee);

    public List<EmployeeResponse> getAll();

    public EmployeeResponse getEmployee(Long empId);

    void updateEmployee(EmployeeRequest employeeRequest);

    void deleteEmployee(Long empId);
}
