package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.trucks;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.drivers.DriversEntity;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages.PackagesEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "TRUCKS")
@SQLDelete(sql = "UPDATE trucks SET is_deleted = true, deleted_at = now() WHERE uuid = ?")
@Where(clause = "is_deleted is false")
@Getter
@Setter
public class TrucksEntity {
    @Id
    private UUID uuid= UUID.randomUUID();
    private String code;
    private Boolean enabled;
    private Boolean isDeleted = Boolean.FALSE;
    private LocalDateTime deletedAt;

    @JoinColumn(name = "drivers", referencedColumnName = "uuid")
    @OneToOne(optional = true)
    private DriversEntity driversEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trucksEntity")
    private List<PackagesEntity> packagesList;

}
