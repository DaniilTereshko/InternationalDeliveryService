package org.international_delivery_service.international_delivery.core.dto.create;

import org.international_delivery_service.international_delivery.core.enums.PackageSize;

public class UpdatePackageDTO {
    private Long id;
    private PackageSize size;

    public UpdatePackageDTO() {
    }

    public UpdatePackageDTO(Long id, PackageSize size) {
        this.id = id;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PackageSize getSize() {
        return size;
    }

    public void setSize(PackageSize size) {
        this.size = size;
    }
}
