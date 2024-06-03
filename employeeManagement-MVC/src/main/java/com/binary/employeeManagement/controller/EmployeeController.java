package com.binary.employeeManagement.controller;

import com.binary.employeeManagement.model.Employee;
import com.binary.employeeManagement.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping({"", "/list"})
    public String employee(Model model) {
        model.addAttribute("employeesList", employeeService.findAllEmployee());
        return "employees/displayEmployee";
    }

    @GetMapping({"/create"})
    public String createEmployee(Model model) {
        model.addAttribute("createEmployee", new Employee());
        return "employees/createEmployee";
    }

    @PostMapping({"/create"})
    public String createEmployee(@Valid @ModelAttribute("createEmployee")
                                 Employee employee, BindingResult result) {
        employeeService.addEmployee(employee);
        if(result.hasErrors()){
            return "employees/createEmployee";
        }
        return "redirect:/employees/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployeePage(@PathVariable("id") int id) {
        return "employees/deleteEmployee";
    }

    @PostMapping({"/delete/{id}"})
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }
    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model) {
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        Employee  updatedEmployee = null;
        if (optionalEmployee.isPresent()) {
            updatedEmployee = optionalEmployee.get();
        } else {
            return "redirect:/employees/list";
        }
        model.addAttribute("updateEmployee", updatedEmployee);
        return "employees/updateEmployee";
    }

    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") int id, @ModelAttribute("updateEmployee") Employee updateEmployee, Errors errors) {
        if (errors.hasErrors()) {
            return "employees/updateEmployee";
        }
        employeeService.updateEmployee(updateEmployee);
        return "redirect:/employees/list";
    }
}