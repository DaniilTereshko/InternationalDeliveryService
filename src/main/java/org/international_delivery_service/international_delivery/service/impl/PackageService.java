package org.international_delivery_service.international_delivery.service.impl;

import org.international_delivery_service.international_delivery.core.dto.create.CreatePackageDTO;
import org.international_delivery_service.international_delivery.core.dto.create.UpdatePackageDTO;
import org.international_delivery_service.international_delivery.core.enums.PackageSize;
import org.international_delivery_service.international_delivery.core.exception.PackageNotFoundException;
import org.international_delivery_service.international_delivery.core.exception.StreetNotDepartmentException;
import org.international_delivery_service.international_delivery.dao.entity.Department;
import org.international_delivery_service.international_delivery.dao.entity.Package;
import org.international_delivery_service.international_delivery.dao.entity.Street;
import org.international_delivery_service.international_delivery.dao.entity.User;
import org.international_delivery_service.international_delivery.dao.repositories.IPackageRepository;
import org.international_delivery_service.international_delivery.service.api.IDepartmentService;
import org.international_delivery_service.international_delivery.service.api.IPackageService;
import org.international_delivery_service.international_delivery.service.api.IStreetService;
import org.international_delivery_service.international_delivery.service.api.IUserService;
import org.springframework.security.core.userdetails.UserDetails;

public class PackageService implements IPackageService {
    private static final String STREET_ERROR = "Данная улица принадлежит к другому департаменту";
    private static final String PACKAGE_NOT_FOUND = "Посылки с таким номером нет";
    private final UserHolder userHolder;
    private final IUserService userService;
    private final IDepartmentService departmentService;
    private final IStreetService streetService;
    private final IPackageRepository packageRepository;

    public PackageService(UserHolder userHolder, IUserService userService, IDepartmentService departmentService, IStreetService streetService, IPackageRepository packageRepository) {
        this.userHolder = userHolder;
        this.userService = userService;
        this.departmentService = departmentService;
        this.streetService = streetService;
        this.packageRepository = packageRepository;
    }

    @Override
    public Package save(CreatePackageDTO dto) {
        UserDetails user = this.userHolder.getUser();
        User owner = this.userService.findByLogin(user.getUsername()).get();
        Department department = this.departmentService.get(dto.getDepartment());
        Street street = this.streetService.get(dto.getStreet());
        if(street.getDepartment() != department){
            throw new StreetNotDepartmentException(STREET_ERROR);
        }
        Package pack = new Package(owner, department, street);
        this.packageRepository.save(pack);
        return pack;
    }

    @Override
    public Package update(UpdatePackageDTO dto) {
        Package aPackage = this.packageRepository.getById(dto.getId())
                .orElseThrow(() -> new PackageNotFoundException((PACKAGE_NOT_FOUND)));
        aPackage.setSize(dto.getSize());
        return this.packageRepository.save(aPackage);
    }

    @Override
    public int countByDepartment(Department department) {
        return this.packageRepository.countByDepartment(department);
    }

    @Override
    public int countByDepartmentIdAndSize(Department department, PackageSize size) {
        return this.packageRepository.countByDepartmentAndSize(department, size);
    }
    @Override
    public int count() {
        return (int)this.packageRepository.count();
    }

    @Override
    public int countBySize(PackageSize size) {
        return this.packageRepository.countBySize(size);
    }
}
