package tech.escalab.spring_boot.proyecto_final.domain.exception.base;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DomainExceptionCode {

    PACKAGES_STATUS_INVALID(201, 400, "el estado actual del PACKAGES no es valido para la solicitud");

    private Integer codeApp;

    private Integer statusCode;

    private String message;
}
