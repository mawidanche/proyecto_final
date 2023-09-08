package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.addapter.packages;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Packages;
import tech.escalab.spring_boot.proyecto_final.domain.port.packages.PackagesPort;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.mapper.packages.PackagesJpaMapper;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.repository.packages.PackagesRepositoryJpa;

import java.util.UUID;

@AllArgsConstructor
@Component
public class PackagesPortAdapter implements PackagesPort {
    //todo agregar control de excepciones de dominio
    private PackagesJpaMapper jpaMapper;
    private PackagesRepositoryJpa repositoryJpa;

    @Override
    public void deleteByUuid(UUID uuid) {
        repositoryJpa.deleteById(uuid);
    }

    @Override
    public Packages findByUuid(UUID uuid) {
        var entity = repositoryJpa.findById(uuid)
                //.orElseThrow(() -> new NotFoundException(DomainExceptionCode.PERSON_NOT_FOUND))
                ;
        return jpaMapper.toDomain(entity.get());
    }

    @Override
    public Packages save(Packages packages) {
        var saved = repositoryJpa.save(
                jpaMapper.toEntity(packages)
        );
        return jpaMapper.toDomain(saved);
    }

    @Override
    public Packages update(Packages toUpdate, Packages found) {
        jpaMapper.updateDomain(toUpdate, found);
        var entity = jpaMapper.toEntity(found);
        return jpaMapper.toDomain(
                repositoryJpa.save(entity)
        );
    }
}
