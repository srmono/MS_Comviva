package com.anz.employeeservice.controller;

import com.anz.employeeservice.model.Employee;
import com.anz.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository empRepo;

    @PostMapping
    public Employee add(@RequestBody Employee emp){
        return empRepo.add(emp);
    }

    @GetMapping
    public List<Employee> findAll(){
        return empRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        return empRepo.findBydId(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findDepartmentById(@PathVariable("departmentId") Long depId){
        return empRepo.findByDepartment(depId);
    }
}
