package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Status;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages_products.PackagesProductsEntity;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.trucks.TrucksEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "PACKAGES")
@Getter
@Setter
public class PackagesEntity {
    @Id
    private UUID uuid= UUID.randomUUID();
    private String code;
    private Double weight;
    private LocalDateTime schedule;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Boolean isDeleted;
    private LocalDateTime deletedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packagesEntity")
    private List<PackagesProductsEntity> packagesProducts;

    @JoinColumn(name = "trucks", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private TrucksEntity trucksEntity;

}
