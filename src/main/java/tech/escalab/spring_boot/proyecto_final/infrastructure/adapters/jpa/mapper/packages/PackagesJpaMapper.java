package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.mapper.packages;

import org.mapstruct.*;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Packages;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.packages.PackagesEntity;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PackagesJpaMapper {
    PackagesEntity toEntity(Packages trucks);
    Packages toDomain(PackagesEntity trucksEntity);

    void updateDomain(Packages toUpdate, @MappingTarget Packages found);
}
