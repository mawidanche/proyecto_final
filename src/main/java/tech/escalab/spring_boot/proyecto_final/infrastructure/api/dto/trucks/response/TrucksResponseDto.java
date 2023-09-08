package tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class TrucksResponseDto {
    private UUID uuid;
    private String  code;
    private Boolean enabled;
    private UUID uuidDrivers;
}
