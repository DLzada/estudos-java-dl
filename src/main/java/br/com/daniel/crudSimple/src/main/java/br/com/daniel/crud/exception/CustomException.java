package br.com.daniel.crud.exception;

public class CustomException extends RuntimeException{
    public CustomException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
