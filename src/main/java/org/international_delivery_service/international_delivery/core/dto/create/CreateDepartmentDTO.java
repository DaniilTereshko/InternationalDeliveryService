package org.international_delivery_service.international_delivery.core.dto.create;

public class CreateDepartmentDTO {
    private String name;

    public CreateDepartmentDTO() {
    }

    public CreateDepartmentDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
