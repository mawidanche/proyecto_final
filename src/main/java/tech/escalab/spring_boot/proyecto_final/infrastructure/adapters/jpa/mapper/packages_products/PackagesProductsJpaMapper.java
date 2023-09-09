package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.mapper.packages_products;

import org.mapstruct.*;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages_products.PackagesProducts;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages_products.PackagesProductsEntity;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.mapper.packages.PackagesJpaMapper;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = PackagesJpaMapper.class
)
public interface PackagesProductsJpaMapper {
    @Mapping(source = "packages", target = "packagesEntity")
    PackagesProductsEntity toEntity(PackagesProducts domain);
    PackagesProducts toDomain(PackagesProductsEntity entity);

    void updateDomain(PackagesProducts toUpdate, @MappingTarget PackagesProducts found);
}
