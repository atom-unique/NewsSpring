package ru.kravchenko.service.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EntityNotFoundExceptionTest {

    @Test
    void entityNotFoundExceptionTest() {
        Assertions.assertThrows(EntityNotFoundException.class,
                () -> {
                    throw new EntityNotFoundException(1L);
                });
    }
}