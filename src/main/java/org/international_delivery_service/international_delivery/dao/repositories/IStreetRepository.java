package org.international_delivery_service.international_delivery.dao.repositories;

import org.international_delivery_service.international_delivery.dao.entity.Department;
import org.international_delivery_service.international_delivery.dao.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStreetRepository extends JpaRepository<Street, Long> {
    Street getByName(String name);
    List<Street> getByDepartment(Department department);
}
