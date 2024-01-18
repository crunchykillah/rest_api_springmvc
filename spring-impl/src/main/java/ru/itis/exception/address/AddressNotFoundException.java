package ru.itis.exception.address;

import ru.itis.exception.NotFoundServiceException;

import java.util.UUID;

public class AddressNotFoundException extends NotFoundServiceException {

    public AddressNotFoundException(UUID uuid) {
        super("Address with id = %s - not found".formatted(uuid));
    }
}
