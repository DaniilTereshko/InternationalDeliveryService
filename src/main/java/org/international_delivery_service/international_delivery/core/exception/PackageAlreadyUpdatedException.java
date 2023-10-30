package org.international_delivery_service.international_delivery.core.exception;

public class PackageAlreadyUpdatedException extends RuntimeException{
    private final String field;

    public PackageAlreadyUpdatedException(String message) {
        super(message);
        this.field = null;
    }

    public PackageAlreadyUpdatedException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
