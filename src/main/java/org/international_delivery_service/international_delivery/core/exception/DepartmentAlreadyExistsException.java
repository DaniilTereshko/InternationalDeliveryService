package org.international_delivery_service.international_delivery.core.exception;

public class DepartmentAlreadyExistsException extends RuntimeException{
    private final String field;

    public DepartmentAlreadyExistsException(String message) {
        super(message);
        this.field = null;
    }

    public DepartmentAlreadyExistsException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
