package org.international_delivery_service.international_delivery.service.impl;

import org.international_delivery_service.international_delivery.core.dto.base.UserRegistrationDTO;
import org.international_delivery_service.international_delivery.core.exception.LoginAlreadyTakenException;
import org.international_delivery_service.international_delivery.dao.entity.User;
import org.international_delivery_service.international_delivery.service.api.IAuthenticationService;
import org.international_delivery_service.international_delivery.service.api.IUserService;

public class AuthenticationService implements IAuthenticationService {
    private static final String USER_ALREADY_EXISTS = "Такой пользователь уже существует";
    private final IUserService userService;

    public AuthenticationService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public User registration(UserRegistrationDTO item) {
        this.userService.findByLogin(item.getLogin())
                .ifPresent(u -> {throw new LoginAlreadyTakenException(USER_ALREADY_EXISTS);});
        return this.userService.save(item);
    }
}
