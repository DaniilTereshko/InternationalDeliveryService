package org.international_delivery_service.international_delivery.endpoints.web.controller;

import org.international_delivery_service.international_delivery.core.dto.base.DepartmentStatisticDTO;
import org.international_delivery_service.international_delivery.core.dto.create.CreateDepartmentDTO;
import org.international_delivery_service.international_delivery.core.exception.DepartmentAlreadyExistsException;
import org.international_delivery_service.international_delivery.dao.entity.Department;
import org.international_delivery_service.international_delivery.service.api.IDepartmentService;
import org.international_delivery_service.international_delivery.service.api.IStatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartmentController {
    private final IDepartmentService departmentService;
    private final IStatisticService statisticService;

    public DepartmentController(IDepartmentService departmentService, IStatisticService statisticService) {
        this.departmentService = departmentService;
        this.statisticService = statisticService;
    }
    @GetMapping("/department")
    public String get(){
        return "department";
    }
    @PostMapping("/department")
    public String add(@RequestParam("name") String name, Model model){
        Department department = null;
        CreateDepartmentDTO dto = new CreateDepartmentDTO(name);
        try {
            department = this.departmentService.save(name);
        }catch (DepartmentAlreadyExistsException e){
            model.addAttribute("error", e.getMessage());
        }
        if(department != null){
            model.addAttribute("ok", "Департамент успешно добавлен");
        }
        return "department";
    }
    @GetMapping("/department/info")
    public String getInformation(Model model){
        model.addAttribute("departments", this.departmentService.get());
        return "statistic";
    }
    @PostMapping("/department/info")
    public String getDepartment(@RequestParam("department") String department, Model model){
        model.addAttribute("departments", this.departmentService.get());
        DepartmentStatisticDTO dto = this.statisticService.getDepartmentStatistic(department);
        model.addAttribute("departmentStatistic", dto);
        return "statistic";
    }
}
