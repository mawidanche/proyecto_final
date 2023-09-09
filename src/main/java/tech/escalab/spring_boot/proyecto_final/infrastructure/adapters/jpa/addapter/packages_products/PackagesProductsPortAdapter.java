package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.addapter.packages_products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages_products.PackagesProducts;
import tech.escalab.spring_boot.proyecto_final.domain.port.packages_products.PackagesProductsPort;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.mapper.packages_products.PackagesProductsJpaMapper;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.repository.packages_products.PackagesProductsRepositoryJpa;

import java.util.UUID;

@AllArgsConstructor
@Component
public class PackagesProductsPortAdapter implements PackagesProductsPort {
    //todo agregar control de excepciones de dominio
    private PackagesProductsJpaMapper jpaMapper;
    private PackagesProductsRepositoryJpa repositoryJpa;

    @Override
    public void deleteByUuid(UUID uuid) {
        repositoryJpa.deleteById(uuid);
    }

    @Override
    public PackagesProducts findByUuid(UUID uuid) {
        var entity = repositoryJpa.findById(uuid)
                //.orElseThrow(() -> new NotFoundException(DomainExceptionCode.PERSON_NOT_FOUND))
                ;
        return jpaMapper.toDomain(entity.get());
    }

    @Override
    public PackagesProducts save(PackagesProducts packages) {
        var saved = repositoryJpa.save(
                jpaMapper.toEntity(packages)
        );
        return jpaMapper.toDomain(saved);
    }

    @Override
    public PackagesProducts update(PackagesProducts toUpdate, PackagesProducts found) {
        jpaMapper.updateDomain(toUpdate, found);
        var entity = jpaMapper.toEntity(found);
        return jpaMapper.toDomain(
                repositoryJpa.save(entity)
        );
    }
}
