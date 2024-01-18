package ru.itis.exception.product;

import ru.itis.exception.NotFoundServiceException;

import java.util.UUID;

public class ProductNotFoundException extends NotFoundServiceException {

    public ProductNotFoundException(UUID uuid) {
        super("Product with id = %s - not found".formatted(uuid));
    }
}
