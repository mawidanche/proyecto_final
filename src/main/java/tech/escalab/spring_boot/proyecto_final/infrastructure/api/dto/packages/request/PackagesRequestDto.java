package tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.escalab.spring_boot.proyecto_final.domain.model.packages.Status;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages_products.request.PackagesProductsRequestDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class PackagesRequestDto {

    private String code;
    private Double weight;
    private LocalDateTime schedule;
    private Status status;
    private UUID uuidTrucks;
    private List<PackagesProductsRequestDto> products;
}
