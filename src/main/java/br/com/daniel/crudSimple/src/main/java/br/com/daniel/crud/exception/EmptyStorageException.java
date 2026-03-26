package br.com.daniel.crud.exception;

public class EmptyStorageException extends RuntimeException{
    public EmptyStorageException(String message) {
        super(message);
    }
}
