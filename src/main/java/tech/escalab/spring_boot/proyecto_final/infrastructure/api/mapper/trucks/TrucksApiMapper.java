package tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.trucks;

import org.mapstruct.*;
import tech.escalab.spring_boot.proyecto_final.domain.model.trucks.Trucks;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.request.TrucksRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.response.TrucksResponseDto;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TrucksApiMapper {

    Trucks toDomain(TrucksRequestDto request);
    TrucksResponseDto toResponse(Trucks trucks);
}
