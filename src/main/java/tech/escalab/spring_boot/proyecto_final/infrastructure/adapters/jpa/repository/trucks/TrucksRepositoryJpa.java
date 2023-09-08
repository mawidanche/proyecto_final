package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.repository.trucks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.trucks.TrucksEntity;

import java.util.UUID;

@Repository
public interface TrucksRepositoryJpa extends CrudRepository<TrucksEntity, UUID> {


}
