package ru.kravchenko.service.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Object param) {
        super("Entity not found by parameter: " + param);
    }
}
