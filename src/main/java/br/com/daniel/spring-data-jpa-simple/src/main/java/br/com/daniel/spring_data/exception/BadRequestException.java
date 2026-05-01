package br.com.daniel.spring_data.exception;

public class BadRequestException extends Exception{
    public BadRequestException(String message) {
        super(message);
    }
}
