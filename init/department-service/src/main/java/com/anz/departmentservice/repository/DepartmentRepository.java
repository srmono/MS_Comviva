package com.anz.departmentservice.repository;

import com.anz.departmentservice.model.Department;
import com.anz.departmentservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department dep){
        departments.add(dep);
        return dep;
    }

    public List<Department> findAll(){
        return departments;
    }

    public Department findById(Long id){
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    

}
