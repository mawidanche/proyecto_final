package tech.escalab.spring_boot.proyecto_final.infrastructure.api.swagger.trucks;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.request.TrucksRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.response.TrucksResponseDto;

import java.util.UUID;

@Tag(name = "Trucks", description = "API de trucks")
public interface TrucksSwagger {

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TrucksResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TrucksResponseDto.class), mediaType = "application/json") })
    })
    TrucksResponseDto save(@RequestBody TrucksRequestDto request);

    @Operation(
            summary = "Buscar truck",
            description = "Endpoint que nos ayuda encontrar un truck por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TrucksResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TrucksResponseDto.class), mediaType = "application/json") })
    })
    TrucksResponseDto findById(UUID uuid);

    @Operation(
            summary = "Actualizar un truck",
            description = "Endpoint que nos ayuda a actualizar un truck por medio de su uuid y la informacion a modificar"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TrucksResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TrucksResponseDto.class), mediaType = "application/json") })
    })
    void update(UUID uui, TrucksRequestDto request);

    void delete(UUID uuid);

}
