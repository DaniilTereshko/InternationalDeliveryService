package org.international_delivery_service.international_delivery.core.exception;

public class UserNotExists extends RuntimeException{
    private final String field;

    public UserNotExists(String message) {
        super(message);
        this.field = null;
    }

    public UserNotExists(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
