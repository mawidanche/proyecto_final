package tech.escalab.spring_boot.proyecto_final.infrastructure.api.swagger.packages_products;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.error.ErrorResponse;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages.response.PackagesResponseDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages_products.request.PackagesProductsRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages_products.response.PackagesProductsResponseDto;

import java.util.UUID;

@Tag(name = "Packages products", description = "API de packages")
public interface PackagesProductsSwagger {

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PackagesResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = PackagesResponseDto.class), mediaType = "application/json") })
    })
    PackagesProductsResponseDto save(@RequestBody PackagesProductsRequestDto request);

    @ApiResponses({
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json") })
    })
    void delete(UUID uuid);
}
