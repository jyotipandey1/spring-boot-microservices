package com.practice.departmentservice.service;

import com.practice.departmentservice.entity.Department;
import com.practice.departmentservice.repositiory.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("inside findDepartmentById method in DepartmentService");
        Department dep = departmentRepository.findDepartmentById(departmentId);
        //log.info(dep.getId()+"");
        return dep;
    }
}
