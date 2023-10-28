package org.international_delivery_service.international_delivery.service.api;

import org.international_delivery_service.international_delivery.core.dto.create.CreateStreetDTO;
import org.international_delivery_service.international_delivery.dao.entity.Department;
import org.international_delivery_service.international_delivery.dao.entity.Street;

import java.util.List;

public interface IStreetService {
    Street save(CreateStreetDTO street);
    List<Street> get();
    List<Street> get(Department department);
    Street get(String name);
}
