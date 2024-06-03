package com.binary.employeeManagement.model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;

    private String name;

    private String department;

    private String role;

}