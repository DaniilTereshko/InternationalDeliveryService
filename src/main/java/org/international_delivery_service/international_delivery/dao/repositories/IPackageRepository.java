package org.international_delivery_service.international_delivery.dao.repositories;

import org.international_delivery_service.international_delivery.core.enums.PackageSize;
import org.international_delivery_service.international_delivery.dao.entity.Department;
import org.international_delivery_service.international_delivery.dao.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IPackageRepository extends JpaRepository<Package, UUID> {
    Optional<Package> getById(Long id);
    int countByDepartment(Department department);
    int countByDepartmentAndSize(Department department, PackageSize size);
    int countBySize(PackageSize size);
}
