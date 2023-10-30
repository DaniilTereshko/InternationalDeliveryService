package org.international_delivery_service.international_delivery.endpoints.web.controller;

import org.international_delivery_service.international_delivery.core.dto.base.UserRegistrationDTO;
import org.international_delivery_service.international_delivery.core.exception.LoginAlreadyTakenException;
import org.international_delivery_service.international_delivery.service.api.IAuthenticationService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
    private final IAuthenticationService authenticationService;

    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("dto", new UserRegistrationDTO());
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(@ModelAttribute("dto") UserRegistrationDTO dto, Model model){
        try {
            this.authenticationService.registration(dto);
        } catch (LoginAlreadyTakenException e){
            model.addAttribute("error", e.getMessage());
            return "registration";
        }
        return "login";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
