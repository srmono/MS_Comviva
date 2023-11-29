package com.anz.employeeservice.repository;

import com.anz.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee>  employees = new ArrayList<>();

    public Employee add(Employee employee){
        employees.add(employee);
        return  employee;
    }

    public Employee findBydId(Long id){
        return  employees.stream()
                .filter(e -> e.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll(){
        return  employees;
    }

    public List<Employee> findByDepartment(Long departmentId){
        return employees.stream()
                .filter(e -> e.departmentId().equals(departmentId)
                ).toList();
    }
}

