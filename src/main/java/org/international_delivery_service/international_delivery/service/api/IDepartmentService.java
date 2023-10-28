package org.international_delivery_service.international_delivery.service.api;

import org.international_delivery_service.international_delivery.core.dto.base.DepartmentDTO;
import org.international_delivery_service.international_delivery.core.dto.create.CreateDepartmentDTO;
import org.international_delivery_service.international_delivery.dao.entity.Department;

import java.util.List;

public interface IDepartmentService {
    Department save(String name);
    List<Department> get();
    Department get(String name);
}
