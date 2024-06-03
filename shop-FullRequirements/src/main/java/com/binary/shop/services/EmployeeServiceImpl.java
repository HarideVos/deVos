package com.binary.shop.services;

import com.binary.shop.entities.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public Employee createEmployee(Employee owner) {
        return owner;
    }
}
