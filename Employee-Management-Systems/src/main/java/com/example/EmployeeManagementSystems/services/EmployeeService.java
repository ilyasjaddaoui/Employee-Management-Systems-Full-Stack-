package com.example.EmployeeManagementSystems.services;

import com.example.EmployeeManagementSystems.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);

}
