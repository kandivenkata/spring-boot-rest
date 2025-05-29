package com.krishna.controller;

import com.krishna.dto.EmployeeRequest;
import com.krishna.dto.EmployeeResponse;
import com.krishna.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("employee")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PutMapping
    public String add(@RequestBody EmployeeRequest employeeRequest){
        employeeService.addEmployee(employeeRequest);
        return "successfully updated";
    }

    @GetMapping
    public List<EmployeeResponse> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeResponse getById(@PathVariable("id") Long empId) {
        return employeeService.getEmployee(empId);
    }

}
