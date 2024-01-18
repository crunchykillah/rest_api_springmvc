package ru.itis.exception.order;

import ru.itis.exception.NotFoundServiceException;

import java.util.UUID;

public class OrderNotFoundException extends NotFoundServiceException {

    public OrderNotFoundException(UUID uuid) {
        super("Order with id = %s - not found".formatted(uuid));
    }
}
