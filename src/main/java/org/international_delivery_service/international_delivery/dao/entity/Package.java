package org.international_delivery_service.international_delivery.dao.entity;

import jakarta.persistence.*;
import org.international_delivery_service.international_delivery.core.enums.PackageSize;

@Entity
@Table(name = "packages")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    private User owner;
    @ManyToOne
    @JoinColumn(name = "department", nullable = false)
    private Department department;
    @ManyToOne
    @JoinColumn(name = "street", nullable = false)
    private Street street;
    @Enumerated(EnumType.STRING)
    private PackageSize size;

    public Package() {
    }

    public Package(User owner, Department department, Street street) {
        this.owner = owner;
        this.department = department;
        this.street = street;
    }

    public Package(Long id, User owner, Department department, Street street, PackageSize size) {
        this.id = id;
        this.owner = owner;
        this.department = department;
        this.street = street;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public PackageSize getSize() {
        return size;
    }

    public void setSize(PackageSize size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        if (getId() != null ? !getId().equals(aPackage.getId()) : aPackage.getId() != null) return false;
        if (getOwner() != null ? !getOwner().equals(aPackage.getOwner()) : aPackage.getOwner() != null) return false;
        if (getDepartment() != null ? !getDepartment().equals(aPackage.getDepartment()) : aPackage.getDepartment() != null)
            return false;
        if (getStreet() != null ? !getStreet().equals(aPackage.getStreet()) : aPackage.getStreet() != null)
            return false;
        return getSize() == aPackage.getSize();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getOwner() != null ? getOwner().hashCode() : 0);
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getSize() != null ? getSize().hashCode() : 0);
        return result;
    }
}
