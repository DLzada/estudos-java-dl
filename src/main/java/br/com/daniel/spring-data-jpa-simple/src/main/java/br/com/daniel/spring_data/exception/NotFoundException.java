package br.com.daniel.spring_data.exception;

public class NotFoundException extends Exception{
    public NotFoundException(String message) {
        super(message);
    }
}
