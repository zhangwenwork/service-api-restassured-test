package com.blog.domain.exceptions;


import java.util.UUID;

public class EntityExistedException extends DomainException {
    public EntityExistedException(String message) {
        super(message);
    }

    public <T> EntityExistedException(Class<T> entityClass, UUID id) {
        super("the " + entityClass.getSimpleName().toLowerCase() + " with id " + id + " was existed");
    }
}
