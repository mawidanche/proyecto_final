package tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.mapper.trucks;

import org.mapstruct.*;
import tech.escalab.spring_boot.proyecto_final.domain.model.trucks.Trucks;
import tech.escalab.spring_boot.proyecto_final.infrastructure.adapters.jpa.entity.trucks.TrucksEntity;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TrucksJpaMapper {
    TrucksEntity toEntity(Trucks trucks);
    Trucks toDomain(TrucksEntity trucksEntity);

    void updateDomain(Trucks toUpdate, @MappingTarget Trucks found);
}
