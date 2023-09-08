package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.drivers;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.trucks.TrucksEntity;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "DRIVERS")
@SQLDelete(sql = "UPDATE drivers SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
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
    private Boolean isDeleted = Boolean.FALSE;
    private LocalDateTime deletedAt;

    @OneToOne(mappedBy = "driversEntity", fetch = FetchType.LAZY)
    private TrucksEntity trucks;

}
