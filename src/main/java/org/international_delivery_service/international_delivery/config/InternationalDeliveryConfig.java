package org.international_delivery_service.international_delivery.config;

import org.international_delivery_service.international_delivery.dao.repositories.IDepartmentRepository;
import org.international_delivery_service.international_delivery.dao.repositories.IPackageRepository;
import org.international_delivery_service.international_delivery.dao.repositories.IStreetRepository;
import org.international_delivery_service.international_delivery.dao.repositories.IUserRepository;
import org.international_delivery_service.international_delivery.service.api.*;
import org.international_delivery_service.international_delivery.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Configuration
public class InternationalDeliveryConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IDepartmentService departmentService(IDepartmentRepository departmentRepository){
        return new DepartmentService(departmentRepository);
    }
    @Bean
    public IStreetService streetService(IStreetRepository streetRepository, IDepartmentService departmentService){
        return new StreetService(streetRepository, departmentService);
    }
    @Bean
    public IUserService userService(IUserRepository userRepository, PasswordEncoder passwordEncoder){
        return new UserService(userRepository, passwordEncoder);
    }
    @Bean
    public IAuthenticationService authenticationService(IUserService userService){
        return new AuthenticationService(userService);
    }
    @Bean
    public IPackageService packageService(UserHolder userHolder, IUserService userService, IDepartmentService departmentService, IStreetService streetService, IPackageRepository packageRepository){
        return new PackageService(userHolder, userService, departmentService, streetService, packageRepository);
    }
    @Bean
    public IStatisticService statisticService(IPackageService packageService, IDepartmentService departmentService, IStreetService streetService){
        return new StatisticService(packageService, departmentService, streetService);
    }
}
