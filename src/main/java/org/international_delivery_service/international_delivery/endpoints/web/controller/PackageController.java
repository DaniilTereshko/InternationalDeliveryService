package org.international_delivery_service.international_delivery.endpoints.web.controller;

import org.international_delivery_service.international_delivery.core.dto.create.CreatePackageDTO;
import org.international_delivery_service.international_delivery.core.dto.create.UpdatePackageDTO;
import org.international_delivery_service.international_delivery.core.enums.PackageSize;
import org.international_delivery_service.international_delivery.core.exception.StreetNotDepartmentException;
import org.international_delivery_service.international_delivery.dao.entity.Package;
import org.international_delivery_service.international_delivery.service.api.IDepartmentService;
import org.international_delivery_service.international_delivery.service.api.IPackageService;
import org.international_delivery_service.international_delivery.service.api.IStreetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PackageController {
    private static final String PACKAGE_REGISTERED = "Посылка зарегистрирована";
    private final IPackageService packageService;
    private final IDepartmentService departmentService;
    private final IStreetService streetService;

    public PackageController(IPackageService packageService, IDepartmentService departmentService, IStreetService streetService) {
        this.packageService = packageService;
        this.departmentService = departmentService;
        this.streetService = streetService;
    }
    @GetMapping("/package")
    public String get(Model model){
        model.addAttribute("departments", this.departmentService.get());
        model.addAttribute("streets", this.streetService.get());
        return "package";
    }
    @PostMapping("/package")
    public String add(@RequestParam("department") String department,
                      @RequestParam("street") String street,
                      Model model){
        model.addAttribute("departments", this.departmentService.get());
        model.addAttribute("streets", this.streetService.get());
        Package savedPackage = null;
        CreatePackageDTO dto = new CreatePackageDTO(department, street);
        try {
            savedPackage = this.packageService.save(dto);
        }catch (StreetNotDepartmentException e){
            model.addAttribute("error", e.getMessage());
        }
        if(savedPackage != null){
            model.addAttribute("ok", PACKAGE_REGISTERED);
        }
        return "package";
    }
}
