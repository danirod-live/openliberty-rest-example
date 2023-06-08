package es.makigas.ejemplos.rest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;

public record ErrorResponse(String field, String message) {
    public ErrorResponse(ConstraintViolation<?> constraint) {
        this(getSimplePath(constraint.getPropertyPath()), constraint.getMessage());
    }
    
    public static String getSimplePath(Path path) {
        String token = path.toString();
        return token.substring(token.lastIndexOf(".") + 1);
    }
}
