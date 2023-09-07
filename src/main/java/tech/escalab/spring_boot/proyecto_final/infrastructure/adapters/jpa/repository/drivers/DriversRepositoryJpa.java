package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.repository.drivers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.drivers.DriversEntity;

import java.util.UUID;

@Repository
public interface DriversRepositoryJpa extends CrudRepository<DriversEntity, UUID> {


}
