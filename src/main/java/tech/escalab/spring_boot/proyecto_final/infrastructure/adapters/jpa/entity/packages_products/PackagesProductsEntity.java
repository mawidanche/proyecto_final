package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages_products;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages.PackagesEntity;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "PACKAGE_PRODUCTS")
@SQLDelete(sql = "UPDATE PACKAGE_PRODUCTS SET is_deleted = true, deleted_at = now() WHERE uuid = ?")
@Where(clause = "is_deleted is false")
@Getter
@Setter
public class PackagesProductsEntity {
    @Id
    private UUID uuid= UUID.randomUUID();
    private String code;
    private Double weight;
    private String sku;
    private Integer quantity;
    private Boolean isDeleted= Boolean.FALSE;
    private LocalDateTime deletedAt;

    @JoinColumn(name = "packages", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private PackagesEntity packagesEntity;


}
