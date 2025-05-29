package com.krishna.service;

import com.krishna.dto.EmployeeRequest;
import com.krishna.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(EmployeeRequest employee);

    public List<EmployeeResponse> getAll();
}
