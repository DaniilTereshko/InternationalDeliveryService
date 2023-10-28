package org.international_delivery_service.international_delivery.core.exception;

public class PackageNotFoundException extends RuntimeException{
    private final String field;

    public PackageNotFoundException(String message) {
        super(message);
        this.field = null;
    }

    public PackageNotFoundException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
