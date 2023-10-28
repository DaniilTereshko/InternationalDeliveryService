package org.international_delivery_service.international_delivery.core.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_USER,
    ROLE_WORKER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
