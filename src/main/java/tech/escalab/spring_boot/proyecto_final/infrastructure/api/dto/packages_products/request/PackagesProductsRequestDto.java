package tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages_products.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class PackagesProductsRequestDto {

    private String code;
    private Double weight;
    private String sku;
    private Integer quantity;
    private UUID uuidPackages;

}
