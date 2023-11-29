package com.anz.departmentservice.controller;

import com.anz.departmentservice.client.EmployeeClient;
import com.anz.departmentservice.model.Department;
import com.anz.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository depRepo;

    @Autowired
    private EmployeeClient employeeClient;

    @GetMapping("/welcome")
    public String welcome(){
        LOGGER.info("Finding all Department ");
        return "welcome";
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Finding all Department ");
        return depRepo.findAll();
    }

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
        return depRepo.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department Find By Id= {}", id);

        return  depRepo.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department Find with employees");

        List<Department> departments = depRepo.findAll();

        departments.forEach(
                dep -> dep.setEmployees(
                        employeeClient.findByDepartmentId(dep.getId())
                )
        );

        return departments;
    }


}

















