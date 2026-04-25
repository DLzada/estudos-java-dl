package br.com.daniel.spring_produtos.exception;

public class NotFoundException extends Exception{
    public NotFoundException(String message) {
        super(message);
    }
}
