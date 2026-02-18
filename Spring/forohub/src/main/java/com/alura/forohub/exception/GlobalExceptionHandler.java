package com.alura.forohub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<ErrorDTO> handleValidacion(ValidacionException ex) {
        return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorCampoDTO>> handleValidacionCampos(MethodArgumentNotValidException ex) {
        List<ErrorCampoDTO> errores = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(ErrorCampoDTO::new)
                .toList();
        return ResponseEntity.badRequest().body(errores);
    }

    public record ErrorDTO(String mensaje) {}

    public record ErrorCampoDTO(String campo, String mensaje) {
        public ErrorCampoDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
