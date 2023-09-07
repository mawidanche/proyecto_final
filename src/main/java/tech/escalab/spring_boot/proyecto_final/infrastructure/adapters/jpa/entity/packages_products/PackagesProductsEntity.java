package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages_products;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages.PackagesEntity;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "PACKAGE_PRODUCTS")
@Getter
@Setter
public class PackagesProductsEntity {
    @Id
    private UUID uuid= UUID.randomUUID();
    private String code;
    private Double weight;
    private String sku;
    private Integer quantity;
    private Boolean isDeleted;
    private LocalDateTime deletedAt;

    @JoinColumn(name = "packages", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private PackagesEntity packagesEntity;


}
