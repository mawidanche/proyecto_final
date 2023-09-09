package tech.escalab.spring_boot.proyecto_final.domain.exception.general;

import tech.escalab.spring_boot.proyecto_final.domain.exception.base.DomainException;
import tech.escalab.spring_boot.proyecto_final.domain.exception.base.DomainExceptionCode;

public class StatusInvalidException extends DomainException {

    public StatusInvalidException(DomainExceptionCode code) {
        super(code);
    }
}
