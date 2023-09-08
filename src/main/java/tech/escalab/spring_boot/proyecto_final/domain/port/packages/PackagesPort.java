package tech.escalab.spring_boot.proyecto_final.domain.port.packages;

import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Packages;

import java.util.UUID;

public interface PackagesPort {

    void deleteByUuid(UUID uuid);

    Packages findByUuid(UUID uuid);

    Packages save(Packages packages);

    Packages update(Packages toUpdate, Packages found);

}
