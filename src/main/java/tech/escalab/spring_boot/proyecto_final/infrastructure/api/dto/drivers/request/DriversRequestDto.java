package tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.drivers.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DriversRequestDto {

    private String code;
    private String name;
    private String cellphone;
    private String email;
    private Boolean enable;
}
