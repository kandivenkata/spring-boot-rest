package com.krishna.service;

import com.krishna.dao.EmployeeRepository;
import com.krishna.dto.EmployeeRequest;
import com.krishna.dto.EmployeeResponse;
import com.krishna.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public EmployeeResponse getEmployee(Long empId) {
      Optional<Employee> optionalEmployee =  employeeRepository.findById(empId);

        return buildEmployeeResponse(optionalEmployee);
    }

    @Override
    public void updateEmployee(EmployeeRequest employeeRequest) {
    Employee employee =  employeeRepository.findById(employeeRequest.getId()).orElseThrow(()->new RuntimeException("employee not found"));
            employee.setName(employeeRequest.getName());
            employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(Long empId) {
        Employee employee =  employeeRepository.findById(empId).orElseThrow(()->new RuntimeException("employee not found"));
        employeeRepository.delete(employee);
    }

    private static EmployeeResponse buildEmployeeResponse(Optional<Employee> optionalEmployee) {
        EmployeeResponse employeeResponse =null;
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employeeResponse =  EmployeeResponse.builder()
                    .empId(employee.getEmpId())
                    .name(employee.getName())
                    .build();
        }
        return employeeResponse;
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
