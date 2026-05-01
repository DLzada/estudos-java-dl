package br.com.daniel.spring_security_gym.exception;

public class BadRequestException extends Exception{
    public BadRequestException(String message) {
        super(message);
    }
}
