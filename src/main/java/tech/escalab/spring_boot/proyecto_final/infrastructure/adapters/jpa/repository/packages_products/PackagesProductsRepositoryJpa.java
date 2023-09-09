package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.repository.packages_products;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages_products.PackagesProductsEntity;

import java.util.UUID;

@Repository
public interface PackagesProductsRepositoryJpa extends CrudRepository<PackagesProductsEntity, UUID> {


}
