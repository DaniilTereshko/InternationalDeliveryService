package org.international_delivery_service.international_delivery.endpoints.web.controller;

import org.international_delivery_service.international_delivery.core.dto.create.UpdatePackageDTO;
import org.international_delivery_service.international_delivery.core.enums.PackageSize;
import org.international_delivery_service.international_delivery.core.exception.PackageAlreadyUpdatedException;
import org.international_delivery_service.international_delivery.core.exception.PackageNotFoundException;
import org.international_delivery_service.international_delivery.core.exception.StreetNotDepartmentException;
import org.international_delivery_service.international_delivery.dao.entity.Package;
import org.international_delivery_service.international_delivery.service.impl.PackageService;
import org.international_delivery_service.international_delivery.service.impl.StatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorkerController {
    private static final String PACKAGING_COMPLETE = "Упаковка закончена";
    private final PackageService packageService;
    private final StatisticService statisticService;

    public WorkerController(PackageService packageService, StatisticService statisticService) {
        this.packageService = packageService;
        this.statisticService = statisticService;
    }
    @GetMapping("/worker")
    public String get(Model model){
        model.addAttribute("statistic", this.statisticService.getPackageStatists());
        return "worker";
    }
    @PostMapping("/worker")
    public String update(@RequestParam("id") Long id, @RequestParam("size") PackageSize size, Model model){
        UpdatePackageDTO dto = new UpdatePackageDTO(id, size);
        Package updatedPackage = null;
        try {
            updatedPackage = this.packageService.update(dto);
        }catch (PackageNotFoundException | PackageAlreadyUpdatedException e){
            model.addAttribute("error", e.getMessage());
        }
        if(updatedPackage != null){
            model.addAttribute("ok", PACKAGING_COMPLETE);
        }
        model.addAttribute("statistic", this.statisticService.getPackageStatists());
        return "worker";
    }
}
