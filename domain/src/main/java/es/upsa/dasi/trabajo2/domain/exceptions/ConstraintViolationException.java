package es.upsa.dasi.trabajo2.domain.exceptions;

public class ConstraintViolationException extends AppException{
    public ConstraintViolationException(String message) {
        super(message);
    }
}
