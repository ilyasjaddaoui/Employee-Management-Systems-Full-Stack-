package com.example.EmployeeManagementSystems.web;

import com.example.EmployeeManagementSystems.entities.Employee;
import com.example.EmployeeManagementSystems.services.EmployeeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee=employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/employees/add/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody @NotNull Employee employee, @PathVariable("id") Long id){
        employee.setId(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees=employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee getEmployee=employeeService.getEmployeeById(id);
        return new ResponseEntity<>(getEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
