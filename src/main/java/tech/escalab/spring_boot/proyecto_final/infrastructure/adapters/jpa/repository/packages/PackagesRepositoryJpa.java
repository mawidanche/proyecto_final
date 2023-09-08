package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.repository.packages;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages.PackagesEntity;

import java.util.UUID;

@Repository
public interface PackagesRepositoryJpa extends CrudRepository<PackagesEntity, UUID> {


}
