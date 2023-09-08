package tech.escalab.spring_boot.proyecto_final.infrastructure.api.swagger.packages;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages.request.PackagesRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.packages.response.PackagesResponseDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.request.TrucksRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.response.TrucksResponseDto;

import java.util.UUID;

@Tag(name = "Packages", description = "API de packages")
public interface PackagesSwagger {

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PackagesResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = PackagesResponseDto.class), mediaType = "application/json") })
    })
    PackagesResponseDto save(@RequestBody PackagesRequestDto request);

    @Operation(
            summary = "Buscar packages",
            description = "Endpoint que nos ayuda encontrar un truck por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PackagesResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = PackagesResponseDto.class), mediaType = "application/json") })
    })
    PackagesResponseDto findById(UUID uuid);

    @Operation(
            summary = "Actualizar un packages",
            description = "Endpoint que nos ayuda a actualizar un packages por medio de su uuid y la informacion a modificar"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PackagesResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = PackagesResponseDto.class), mediaType = "application/json") })
    })
    void update(UUID uui, PackagesRequestDto request);

    void delete(UUID uuid);

}
