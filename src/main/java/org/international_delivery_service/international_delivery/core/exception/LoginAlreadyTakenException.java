package org.international_delivery_service.international_delivery.core.exception;

public class LoginAlreadyTakenException extends RuntimeException{
    private final String field;

    public LoginAlreadyTakenException(String message) {
        super(message);
        this.field = null;
    }

    public LoginAlreadyTakenException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
