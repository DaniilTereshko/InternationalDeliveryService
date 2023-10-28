package org.international_delivery_service.international_delivery.endpoints.web.controller;

import org.international_delivery_service.international_delivery.core.dto.create.CreateStreetDTO;
import org.international_delivery_service.international_delivery.core.exception.StreetAlreadyExistsException;
import org.international_delivery_service.international_delivery.dao.entity.Street;
import org.international_delivery_service.international_delivery.service.api.IDepartmentService;
import org.international_delivery_service.international_delivery.service.api.IStreetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StreetController {
    private final IStreetService streetService;
    private final IDepartmentService departmentService;

    public StreetController(IStreetService streetService, IDepartmentService departmentService) {
        this.streetService = streetService;
        this.departmentService = departmentService;
    }
    @GetMapping("/street")
    public String showCreateStreetForm(Model model) {
        model.addAttribute("departments", this.departmentService.get());
        return "street";
    }

    @PostMapping("/street")
    public String createStreet(@RequestParam("name") String name,
                               @RequestParam("department") String department,
                               Model model) {
        Street savedStreet = null;
        model.addAttribute("departments", this.departmentService.get());
        CreateStreetDTO street = new CreateStreetDTO(name, department);
        try {
            savedStreet = this.streetService.save(street);
        }catch (StreetAlreadyExistsException e){
            model.addAttribute("error", e.getMessage());
        }
        if(savedStreet != null){
            model.addAttribute("ok", "Улица успешно добавлена");
        }
        return "street";
    }
}
