package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.drivers;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.trucks.TrucksEntity;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "DRIVERS")
@Getter
@Setter
public class DriversEntity {
    @Id
    private UUID uuid = UUID.randomUUID();
    private String code;
    private String name;
    private String cellphone;
    private String email;
    private Boolean enable;
    private Boolean isDeleted;
    private LocalDateTime deletedAt;

    @OneToOne(mappedBy = "driversEntity", fetch = FetchType.LAZY)
    private TrucksEntity trucks;

}
