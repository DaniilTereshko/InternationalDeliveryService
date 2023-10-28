package org.international_delivery_service.international_delivery.core.dto.base;

public class UserRegistrationDTO {
    private String login;
    private String password;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
