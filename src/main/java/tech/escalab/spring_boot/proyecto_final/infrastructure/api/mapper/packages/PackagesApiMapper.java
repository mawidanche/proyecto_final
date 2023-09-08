package tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.packages;

import org.mapstruct.*;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Packages;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages.request.PackagesRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages.response.PackagesResponseDto;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PackagesApiMapper {

    Packages toDomain(PackagesRequestDto request);
    PackagesResponseDto toResponse(Packages trucks);
}
