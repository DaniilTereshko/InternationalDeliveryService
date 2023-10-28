package org.international_delivery_service.international_delivery.service.api;

import org.international_delivery_service.international_delivery.core.dto.base.UserRegistrationDTO;
import org.international_delivery_service.international_delivery.dao.entity.User;

public interface IAuthenticationService {
    User registration(UserRegistrationDTO item);
}
