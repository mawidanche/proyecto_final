package tech.escalab.spring_boot.proyecto_final.domain.port.drivers;

import tech.escalab.spring_boot.proyecto_final.domain.model.drivers.Drivers;

import java.util.UUID;

public interface DriversPort {

    void deleteByUuid(UUID uuid);

    Drivers findByUuid(UUID uuid);

    Drivers save(Drivers drivers);

    Drivers update(Drivers driversToUpdate, Drivers driversFound);

}
