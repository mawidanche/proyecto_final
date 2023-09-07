package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.mapper.drivers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import tech.escalab.spring_boot.proyecto_final.domain.model.drivers.Drivers;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.drivers.DriversEntity;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface DriversJpaMapper {
    DriversEntity toEntity(Drivers drivers);
    Drivers toDomain(DriversEntity driversEntity);

    void updateDomain(Drivers driversToUpdate, @MappingTarget Drivers diversFound);
}
