package com.krishna.controller;

import com.krishna.dto.EmployeeRequest;
import com.krishna.dto.EmployeeResponse;
import com.krishna.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("employee")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody EmployeeRequest employeeRequest){
        employeeService.addEmployee(employeeRequest);
        return ResponseEntity.ok("successfully updated");
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> get(@PathVariable("id") Long empId) {
        return ResponseEntity.ok(employeeService.getEmployee(empId));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody EmployeeRequest employeeRequest){
        employeeService.updateEmployee(employeeRequest);
        return ResponseEntity.ok("successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long empId) {
        employeeService.deleteEmployee(empId);
        return ResponseEntity.ok("successfully deleted");
    }

}
