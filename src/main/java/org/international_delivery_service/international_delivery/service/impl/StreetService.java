package org.international_delivery_service.international_delivery.service.impl;

import org.international_delivery_service.international_delivery.core.dto.create.CreateStreetDTO;
import org.international_delivery_service.international_delivery.core.exception.StreetAlreadyExistsException;
import org.international_delivery_service.international_delivery.dao.entity.Department;
import org.international_delivery_service.international_delivery.dao.entity.Street;
import org.international_delivery_service.international_delivery.dao.repositories.IStreetRepository;
import org.international_delivery_service.international_delivery.service.api.IDepartmentService;
import org.international_delivery_service.international_delivery.service.api.IStreetService;

import java.util.List;

public class StreetService implements IStreetService {
    private static final String STREET_EXISTS = "Такая улица уже существует";
    private final IStreetRepository streetRepository;
    private final IDepartmentService departmentService;

    public StreetService(IStreetRepository streetRepository, IDepartmentService departmentService) {
        this.streetRepository = streetRepository;
        this.departmentService = departmentService;
    }

    @Override
    public Street save(CreateStreetDTO dto) {
        if(this.streetRepository.getByName(dto.getName()) != null){
            throw new StreetAlreadyExistsException(STREET_EXISTS);
        }
        Department department = this.departmentService.get(dto.getDepartment());
        Street street = new Street(dto.getName(), department);
        return this.streetRepository.save(street);
    }
    @Override
    public List<Street> get() {
        return this.streetRepository.findAll();
    }

    @Override
    public List<Street> get(Department department) {
        return this.streetRepository.getByDepartment(department);
    }

    @Override
    public Street get(String name) {
        return this.streetRepository.getByName(name);
    }
}
