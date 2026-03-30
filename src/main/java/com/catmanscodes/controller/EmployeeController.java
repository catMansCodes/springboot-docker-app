package com.catmanscodes.controller;

import com.catmanscodes.model.Employee;
import com.catmanscodes.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {

        return ResponseEntity.ok(employeeService.updateEmployee(employee, id));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        Employee employeeById = employeeService.getEmployeeById(id);

        employeeService.deleteEmployee(employeeById);

        return ResponseEntity.ok("Employee with id " + id + " deleted successfully");
    }

}
