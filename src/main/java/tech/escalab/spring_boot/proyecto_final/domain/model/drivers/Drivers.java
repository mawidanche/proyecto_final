package tech.escalab.spring_boot.proyecto_final.domain.model.drivers;

import tech.escalab.spring_boot.proyecto_final.domain.model.trucks.Trucks;

import java.time.LocalDateTime;
import java.util.UUID;



public class Drivers {

    private UUID uuid;
    private String code;
    private String name;
    private String cellphone;
    private String email;
    private Boolean enable;
    private Boolean isDeleted;
    private LocalDateTime deletedAt;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
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
}
