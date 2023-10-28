package org.international_delivery_service.international_delivery.service.impl;

import org.international_delivery_service.international_delivery.core.dto.base.DepartmentStatisticDTO;
import org.international_delivery_service.international_delivery.core.dto.base.PackageStatisticDTO;
import org.international_delivery_service.international_delivery.core.enums.PackageSize;
import org.international_delivery_service.international_delivery.dao.entity.Department;
import org.international_delivery_service.international_delivery.dao.entity.Street;
import org.international_delivery_service.international_delivery.service.api.IDepartmentService;
import org.international_delivery_service.international_delivery.service.api.IPackageService;
import org.international_delivery_service.international_delivery.service.api.IStatisticService;
import org.international_delivery_service.international_delivery.service.api.IStreetService;

import java.util.List;

public class StatisticService implements IStatisticService {
    private final IPackageService packageService;
    private final IDepartmentService departmentService;
    private final IStreetService streetService;

    public StatisticService(IPackageService packageService, IDepartmentService departmentService, IStreetService streetService) {
        this.packageService = packageService;
        this.departmentService = departmentService;
        this.streetService = streetService;
    }

    @Override
    public DepartmentStatisticDTO getDepartmentStatistic(String department) {
        Department dep = this.departmentService.get(department);
        List<Street> streets = this.streetService.get(dep);
        int allPackages = this.packageService.countByDepartment(dep);
        int smallPackages = this.packageService.countByDepartmentIdAndSize(dep, PackageSize.SMALL);
        int mediumPackages = this.packageService.countByDepartmentIdAndSize(dep, PackageSize.MEDIUM);
        int largePackages = this.packageService.countByDepartmentIdAndSize(dep, PackageSize.LARGE);
        return new DepartmentStatisticDTO(allPackages, smallPackages, mediumPackages, largePackages, streets);
    }

    @Override
    public PackageStatisticDTO getPackageStatists() {
        int allPackages = this.packageService.count();
        int smallPackages = this.packageService.countBySize(PackageSize.SMALL);
        int mediumPackages = this.packageService.countBySize(PackageSize.MEDIUM);
        int largePackages = this.packageService.countBySize(PackageSize.LARGE);
        return new PackageStatisticDTO(allPackages, smallPackages, mediumPackages, largePackages);
    }
}
