package org.international_delivery_service.international_delivery.core.dto.create;

public class CreatePackageDTO {
    private String department;
    private String street;

    public CreatePackageDTO() {
    }

    public CreatePackageDTO(String department, String street) {
        this.department = department;
        this.street = street;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
