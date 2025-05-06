package com.br.MyFinance.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError field : ex.getBindingResult().getFieldErrors()) {
            errors.put(field.getField(), field.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailJaExistenteException.class)
    public ResponseEntity<Map<String, String>> handleEmailConflict(EmailJaExistenteException ex) {
        return ResponseEntity.status(409).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneric(Exception ex) {
        logger.error("Erro inesperado:", ex); // loga com stack trace
        return ResponseEntity.status(500).body(Map.of(
                "error", "Erro interno no servidor",
                "detalhe", ex.getMessage()
        ));
    }
}
