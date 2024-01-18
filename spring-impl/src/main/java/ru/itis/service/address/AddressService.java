package ru.itis.service.address;

import ru.itis.dto.request.address.AddressRequest;
import ru.itis.dto.response.address.AddressResponse;

import java.util.Set;
import java.util.UUID;

public interface AddressService {
    public AddressResponse getById(UUID uuid);
    public Set<AddressResponse> getAll();
    public UUID create(AddressRequest addressRequest);
    public void updateField(UUID uuid, String fieldName, String value);
    public void updateAddress(UUID uuid, AddressRequest addressRequest);
    public void delete(UUID uuid);
}
