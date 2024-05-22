package com.binary.employeeManagement.repositories;

import com.binary.employeeManagement.model.Employee;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    List<Employee> employeeList = new ArrayList<>();
    private Integer id = 0;

    public EmployeeRepository() {

    }
    public void addEmployee(Employee employee) {
        employee.setId(id);
        employeeList.add(employee);
        id++;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public List<Employee> deleteEmployeeById(int id){
        for (int i = 0; i < employeeList.size(); i++) {

            if(employeeList.get(i).getId()==id){
                employeeList.remove(i);
                break;
            }
        }
        return employeeList;
    }

    public Optional<Employee> getEmployeeById(int id){
        return employeeList.stream().filter(employee -> employee.getId()==id).findFirst();
    }

    public void updateEmployee (Employee updateEmployee){
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getId()==(updateEmployee.getId())){
                employeeList.set(i, updateEmployee);
                break;
            }
        }
    }

}