package org.international_delivery_service.international_delivery.core.dto.base;

import java.util.List;

public class DepartmentDTO {
    private String name;
    private List<String> streets;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String name, List<String> streets) {
        this.name = name;
        this.streets = streets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStreets() {
        return streets;
    }

    public void setStreets(List<String> streets) {
        this.streets = streets;
    }
}
