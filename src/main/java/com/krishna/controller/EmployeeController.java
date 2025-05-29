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

    @PostMapping
    public String add(@RequestBody EmployeeRequest employeeRequest){
        employeeService.addEmployee(employeeRequest);
        return "successfully added";
    }

    @GetMapping
    public List<EmployeeResponse> getAll() {
        return employeeService.getAll();
    }
}
