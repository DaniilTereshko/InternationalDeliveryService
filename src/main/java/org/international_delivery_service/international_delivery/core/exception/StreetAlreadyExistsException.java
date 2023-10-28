package org.international_delivery_service.international_delivery.core.exception;

public class StreetAlreadyExistsException extends RuntimeException{
    private final String field;

    public StreetAlreadyExistsException(String message) {
        super(message);
        this.field = null;
    }

    public StreetAlreadyExistsException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
