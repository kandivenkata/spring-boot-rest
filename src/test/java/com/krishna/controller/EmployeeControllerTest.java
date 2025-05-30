package com.krishna.controller;

import com.krishna.dao.EmployeeRepository;
import com.krishna.dto.EmployeeResponse;
import com.krishna.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    EmployeeService mockEmployeeService;

    @Mock
    EmployeeRepository mockEmployeeRepository;

    @InjectMocks
    EmployeeController employeeController;

    @Test
    void testGetEmployee(){
        Mockito.when(mockEmployeeService.getEmployee(any())).thenReturn(getEmployeeResponse());
        ResponseEntity<EmployeeResponse> responseEntity = employeeController.get(1l);
        Assertions.assertEquals(1, responseEntity.getBody().getEmpId());

    }

    private EmployeeResponse getEmployeeResponse(){

        return EmployeeResponse.builder()
                .empId(1)
                .name("Krishna")
                .build();
    }


}
