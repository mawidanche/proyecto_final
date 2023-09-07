package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.addapter.drivers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.model.drivers.Drivers;
import tech.escalab.spring_boot.proyecto_final.domain.port.drivers.DriversPort;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.repository.drivers.DriversRepositoryJpa;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.mapper.drivers.DriversJpaMapper;

import java.util.UUID;

@AllArgsConstructor
@Component
public class DriversPortAdapter implements DriversPort {
    private DriversJpaMapper driversJpaMapper;
    private DriversRepositoryJpa driversRepositoryJpa;

    @Override
    public void deleteByUuid(UUID uuid) {

    }

    @Override
    public Drivers findByUuid(UUID uuid) {
        return null;
    }

    @Override
    public Drivers save(Drivers drivers) {
        var savedDrivers = driversRepositoryJpa.save(
                driversJpaMapper.toEntity(drivers)
        );
        return driversJpaMapper.toDomain(savedDrivers);
    }

    @Override
    public Drivers update(Drivers driversToUpdate, Drivers driversFound) {
        return null;
    }
}
