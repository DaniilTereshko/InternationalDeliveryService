package org.international_delivery_service.international_delivery.dao.repositories;

import org.international_delivery_service.international_delivery.dao.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDepartmentRepository extends JpaRepository<Department, UUID> {
    Department getByName(String name);

}
