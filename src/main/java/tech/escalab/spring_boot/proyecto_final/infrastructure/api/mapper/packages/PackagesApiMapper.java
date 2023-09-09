package tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.packages;

import org.mapstruct.*;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Packages;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages.request.PackagesRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages.response.PackagesResponseDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.mapper.packages_products.PackagesProductsApiMapper;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {PackagesProductsApiMapper.class}
)
public interface PackagesApiMapper {

    @Mapping(source = "products", target = "packagesProducts")
    Packages toDomain(PackagesRequestDto request);
    PackagesResponseDto toResponse(Packages trucks);
}
