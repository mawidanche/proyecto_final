package tech.escalab.spring_boot.proyecto_final.domain.model.trucks;

import tech.escalab.spring_boot.proyecto_final.domain.model.drivers.Drivers;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Packages;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Trucks {
    private UUID uuid;
    private String code;
    private Boolean enabled;
    private Boolean isDeleted;
    private LocalDateTime deletedAt;
    private Drivers drivers;
    private List<Packages> packagesList;

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Drivers getDrivers() {
        return drivers;
    }

    public void setDrivers(Drivers drivers) {
        this.drivers = drivers;
    }

    public List<Packages> getPackagesList() {
        return packagesList;
    }

    public void setPackagesList(List<Packages> packagesList) {
        this.packagesList = packagesList;
    }
}
