package com.binary.employeeManagement.services;

import com.binary.employeeManagement.model.Employee;
import com.binary.employeeManagement.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private EmployeeRepository repository;

    public void addEmployee(Employee employee) {
        repository.addEmployee(employee);
    }

    public List<Employee> findAllEmployee() {
        return repository.getAllEmployees();
    }
    public List<Employee> deleteEmployeeById(int id){
        return repository.deleteEmployeeById(id);

    }
    public Optional<Employee> findById(int id){
        return repository.getEmployeeById(id);
    }
    public void updateEmployee(Employee employee){
        repository.updateEmployee(employee);

    }
}