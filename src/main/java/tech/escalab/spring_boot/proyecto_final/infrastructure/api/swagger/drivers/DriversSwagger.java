package tech.escalab.spring_boot.proyecto_final.infrastructure.api.swagger.drivers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.drivers.request.DriversRequestDto;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.drivers.response.DriversResponseDto;

@Tag(name = "Drivers", description = "API de drivers")
public interface DriversSwagger {

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriversResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriversResponseDto.class), mediaType = "application/json") })
    })
    DriversResponseDto save(@RequestBody DriversRequestDto request);
}
