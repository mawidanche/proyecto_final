package tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.drivers.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class DriversResponseDto {
    private UUID uuid;
    private String code;
    private String name;
    private String cellphone;
    private String email;
    private Boolean enable;
}
