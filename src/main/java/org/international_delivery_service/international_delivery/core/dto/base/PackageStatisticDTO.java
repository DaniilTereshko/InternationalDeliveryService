package org.international_delivery_service.international_delivery.core.dto.base;

public class PackageStatisticDTO {
    private int packages;
    private int smallPackages;
    private int mediumPackages;
    private int largePackages;

    public PackageStatisticDTO() {
    }

    public PackageStatisticDTO(int packages, int smallPackages, int mediumPackages, int largePackages) {
        this.packages = packages;
        this.smallPackages = smallPackages;
        this.mediumPackages = mediumPackages;
        this.largePackages = largePackages;
    }

    public int getPackages() {
        return packages;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }

    public int getSmallPackages() {
        return smallPackages;
    }

    public void setSmallPackages(int smallPackages) {
        this.smallPackages = smallPackages;
    }

    public int getMediumPackages() {
        return mediumPackages;
    }

    public void setMediumPackages(int mediumPackages) {
        this.mediumPackages = mediumPackages;
    }

    public int getLargePackages() {
        return largePackages;
    }

    public void setLargePackages(int largePackages) {
        this.largePackages = largePackages;
    }
}
