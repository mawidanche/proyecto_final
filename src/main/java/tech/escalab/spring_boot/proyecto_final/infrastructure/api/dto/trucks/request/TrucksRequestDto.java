package tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.trucks.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TrucksRequestDto {

    private String  code;
    private Boolean enabled;

}
