package org.international_delivery_service.international_delivery.service.impl;

import org.international_delivery_service.international_delivery.core.exception.DepartmentAlreadyExistsException;
import org.international_delivery_service.international_delivery.dao.entity.Department;
import org.international_delivery_service.international_delivery.dao.repositories.IDepartmentRepository;
import org.international_delivery_service.international_delivery.service.api.IDepartmentService;

import java.util.List;
import java.util.UUID;

public class DepartmentService implements IDepartmentService {
    private static final String DEPARTMENT_EXISTS = "Отдел уже существует";
    private final IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(String name) {
        if(this.departmentRepository.getByName(name) != null){
            throw new DepartmentAlreadyExistsException(DEPARTMENT_EXISTS);
        }
        Department department = new Department(UUID.randomUUID(), name);
        return this.departmentRepository.save(department);
    }

    @Override
    public List<Department> get() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Department get(String name) {
        return this.departmentRepository.getByName(name);
    }
}
