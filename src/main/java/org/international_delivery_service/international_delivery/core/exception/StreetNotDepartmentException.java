package org.international_delivery_service.international_delivery.core.exception;

public class StreetNotDepartmentException extends RuntimeException{
    private final String field;

    public StreetNotDepartmentException(String message) {
        super(message);
        this.field = null;
    }

    public StreetNotDepartmentException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
