package tech.escalab.spring_boot.proyecto_final.domain.port.trucks;

import tech.escalab.spring_boot.proyecto_final.domain.model.trucks.Trucks;

import java.util.UUID;

public interface TrucksPort {

    void deleteByUuid(UUID uuid);

    Trucks findByUuid(UUID uuid);

    Trucks save(Trucks trucks);

    Trucks update(Trucks trucksToUpdate, Trucks trucksFound);

}
