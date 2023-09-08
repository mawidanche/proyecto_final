package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.addapter.trucks;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.model.trucks.Trucks;
import tech.escalab.spring_boot.proyecto_final.domain.port.trucks.TrucksPort;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.mapper.trucks.TrucksJpaMapper;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.repository.trucks.TrucksRepositoryJpa;

import java.util.UUID;

@AllArgsConstructor
@Component
public class TrucksPortAdapter implements TrucksPort {
    //todo agregar control de excepciones de dominio
    private TrucksJpaMapper jpaMapper;
    private TrucksRepositoryJpa repositoryJpa;

    @Override
    public void deleteByUuid(UUID uuid) {
        repositoryJpa.deleteById(uuid);
    }

    @Override
    public Trucks findByUuid(UUID uuid) {
        var entity = repositoryJpa.findById(uuid)
                //.orElseThrow(() -> new NotFoundException(DomainExceptionCode.PERSON_NOT_FOUND))
                ;
        return jpaMapper.toDomain(entity.get());
    }

    @Override
    public Trucks save(Trucks trucks) {
        var savedDrivers = repositoryJpa.save(
                jpaMapper.toEntity(trucks)
        );
        return jpaMapper.toDomain(savedDrivers);
    }

    @Override
    public Trucks update(Trucks toUpdate, Trucks found) {
        jpaMapper.updateDomain(toUpdate, found);
        var entity = jpaMapper.toEntity(found);
        return jpaMapper.toDomain(
                repositoryJpa.save(entity)
        );
    }
}
