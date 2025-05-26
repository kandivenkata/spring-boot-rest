package com.krishna.controller;

import com.krishna.dto.EmployeeRequest;
import com.krishna.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("employee")
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    @ResponseBody
    public String add(@RequestBody EmployeeRequest employeeRequest){
        employeeService.addEmployee(employeeRequest);
        return "successfully added";
    }
}
