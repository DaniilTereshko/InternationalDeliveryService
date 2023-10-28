package org.international_delivery_service.international_delivery.core.dto.create;

import org.international_delivery_service.international_delivery.dao.entity.Department;

public class CreateStreetDTO {
    private String name;
    private String department;

    public CreateStreetDTO() {
    }

    public CreateStreetDTO(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
