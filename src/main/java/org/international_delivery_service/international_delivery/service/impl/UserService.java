package org.international_delivery_service.international_delivery.service.impl;

import org.international_delivery_service.international_delivery.core.dto.base.UserRegistrationDTO;
import org.international_delivery_service.international_delivery.core.enums.UserRole;
import org.international_delivery_service.international_delivery.dao.entity.User;
import org.international_delivery_service.international_delivery.dao.repositories.IUserRepository;
import org.international_delivery_service.international_delivery.service.api.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(UserRegistrationDTO item) {
        User user = new User(UUID.randomUUID(), item.getLogin(),
                this.passwordEncoder.encode(item.getPassword()), UserRole.ROLE_USER);
        return this.userRepository.saveAndFlush(user);
    }
    @Override
    public Optional<User> findByLogin(String login) {
        return this.userRepository.findByLogin(login);
    }
}
