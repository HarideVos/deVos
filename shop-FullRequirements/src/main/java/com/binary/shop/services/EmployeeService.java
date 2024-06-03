package com.binary.shop.services;

import com.binary.shop.entities.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    public Employee createEmployee(Employee owner);

}
