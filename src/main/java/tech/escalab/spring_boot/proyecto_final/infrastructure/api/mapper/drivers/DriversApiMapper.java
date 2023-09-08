package tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.drivers;

import org.mapstruct.*;
import tech.escalab.spring_boot.proyecto_final.domain.model.drivers.Drivers;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.drivers.request.DriversRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.drivers.response.DriversResponseDto;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface DriversApiMapper {

    Drivers toDomain(DriversRequestDto request);
    DriversResponseDto toResponse(Drivers drivers);
}
