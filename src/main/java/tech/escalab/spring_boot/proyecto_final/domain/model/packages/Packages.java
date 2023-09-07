package tech.escalab.spring_boot.proyecto_final.domain.model.packages;

import tech.escalab.spring_boot.proyecto_final.domain.model.packages_products.PackagesProducts;
import tech.escalab.spring_boot.proyecto_final.domain.model.trucks.Trucks;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Packages {
    private UUID uuid;
    private String code;
    private Double weight;
    private LocalDateTime schedule;
    private Status status;
    private Boolean isDeleted;
    private LocalDateTime deletedAt;
    private List<PackagesProducts> packagesProducts;
    private Trucks trucks;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Trucks getTrucks() {
        return trucks;
    }

    public void setTrucks(Trucks trucks) {
        this.trucks = trucks;
    }

    public List<PackagesProducts> getPackagesProducts() {
        return packagesProducts;
    }

    public void setPackagesProducts(List<PackagesProducts> packagesProducts) {
        this.packagesProducts = packagesProducts;
    }
}
