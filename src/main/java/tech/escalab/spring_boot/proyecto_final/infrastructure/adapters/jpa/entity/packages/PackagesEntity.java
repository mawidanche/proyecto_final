package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Status;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages_products.PackagesProductsEntity;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.trucks.TrucksEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "PACKAGES")
@SQLDelete(sql = "UPDATE packages SET is_deleted = true, deleted_at = now() WHERE uuid = ?")
@Where(clause = "is_deleted is false")
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
    private Boolean isDeleted= Boolean.FALSE;
    private LocalDateTime deletedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packagesEntity")
    private List<PackagesProductsEntity> packagesProducts;

    @JoinColumn(name = "trucks", referencedColumnName = "uuid")
    @ManyToOne(optional = true)
    private TrucksEntity trucksEntity;

}
