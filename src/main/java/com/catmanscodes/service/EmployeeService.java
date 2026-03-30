package com.catmanscodes.service;

import com.catmanscodes.model.Employee;
import com.catmanscodes.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //get all employees
    public List<Employee> getAllEmployees() {
        System.out.println("Getting all employees from the database"+ employeeRepository.findAll());
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) throws RuntimeException {

        Optional<Employee> employeeById = employeeRepository.findById(id);

        if(employeeById.isPresent()) {
            return employeeById.get();
        } else {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employeeById) {
        employeeRepository.delete(employeeById);
    }

    public Employee updateEmployee(Employee employee, int id) {

        Employee employeeById = this.getEmployeeById(id);

        employeeById.setName(employee.getName());
        employeeById.setDepartment(employee.getDepartment());
        employeeById.setSalary(employee.getSalary());
        employeeById.setEmail(employee.getEmail());

        return employeeRepository.save(employeeById);

    }
}
