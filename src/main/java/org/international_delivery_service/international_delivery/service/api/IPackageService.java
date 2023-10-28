package org.international_delivery_service.international_delivery.service.api;

import org.international_delivery_service.international_delivery.core.dto.create.CreatePackageDTO;
import org.international_delivery_service.international_delivery.core.dto.create.UpdatePackageDTO;
import org.international_delivery_service.international_delivery.core.enums.PackageSize;
import org.international_delivery_service.international_delivery.dao.entity.Department;
import org.international_delivery_service.international_delivery.dao.entity.Package;

import java.util.UUID;

public interface IPackageService {
    Package save(CreatePackageDTO dto);

    Package update(UpdatePackageDTO dto);
    int countByDepartment(Department department);
    int countByDepartmentIdAndSize(Department department, PackageSize size);
    int count();
    int countBySize(PackageSize size);
}
