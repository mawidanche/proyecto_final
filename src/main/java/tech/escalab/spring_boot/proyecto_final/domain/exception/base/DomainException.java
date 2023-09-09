package tech.escalab.spring_boot.proyecto_final.domain.exception.base;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException{
    private DomainExceptionCode code;

    protected DomainException(DomainExceptionCode code) {

        this.code = code;
    }

    protected DomainException(DomainExceptionCode code, Throwable throwable) {

        super(throwable);
        this.code = code;
    }

}
