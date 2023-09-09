package tech.escalab.spring_boot.proyecto_final.infrastructure.api.handler;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.escalab.spring_boot.proyecto_final.domain.exception.base.DomainException;
import tech.escalab.spring_boot.proyecto_final.infrastructure.api.dto.error.ErrorResponse;

import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class HandlerController {
    private Logger LOG = LoggerFactory.getLogger(HandlerController.class);
    private ResponseEntity<ErrorResponse> buildResponse(Integer codeAppError, HttpStatus httpStatus, String message, Object detail) {

        var errorResponse = ErrorResponse.builder()
                .codeAppError(codeAppError)
                .httpStatus(httpStatus.value())
                .message(message)
                .detailMessage(detail)
                .build();

        return new ResponseEntity(errorResponse, httpStatus);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception) {

        LOG.error("Error found: ", exception);

        List<String> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return buildResponse(101, HttpStatus.BAD_REQUEST, "validation_error", errors);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> generalError(Exception exception) {

        LOG.error("Error found: ", exception);

        return buildResponse(100, HttpStatus.INTERNAL_SERVER_ERROR, "general_error", exception.getMessage());
    }

    private ResponseEntity<ErrorResponse> buildResponseWithDomainException(DomainException exception) {

        var httpStatusFound = HttpStatus.valueOf(exception.getCode().getStatusCode());

        var errorResponse = ErrorResponse.builder()
                .codeAppError(exception.getCode().getCodeApp())
                .httpStatus(httpStatusFound.value())
                .message(exception.getCode().getMessage())
                .detailMessage(exception.getMessage())
                .build();

        return new ResponseEntity(errorResponse, httpStatusFound);
    }
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> domainError(DomainException exception) {

        LOG.warn("Exception found: ", exception);

        return buildResponseWithDomainException(exception);
    }

}
