package com.binary.shop.services;

import com.binary.shop.entities.Employee;
import com.binary.shop.services.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee("John", "Doe");

        Employee createdEmployee = employeeService.createEmployee(employee);

        assertEquals(employee, createdEmployee);
    }
}