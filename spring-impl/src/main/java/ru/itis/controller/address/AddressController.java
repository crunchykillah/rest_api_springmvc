package ru.itis.controller.address;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.address.AddressApi;
import ru.itis.dto.request.address.AddressRequest;
import ru.itis.dto.response.address.AddressResponse;
import ru.itis.service.address.JooqAddressService;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AddressController implements AddressApi {

    private final JooqAddressService service;

    @Override
    public AddressResponse getById(UUID uuid) {
        return service.getById(uuid);
    }

    @Override
    public Set<AddressResponse> getAll() {
        return service.getAll();
    }

    @Override
    public UUID create(AddressRequest addressRequest) {
        return service.create(addressRequest);
    }

    @Override
    public void delete(UUID uuid) {
        service.delete(uuid);
    }

    @Override
    public void update(UUID uuid, AddressRequest addressRequest) {
        service.updateAddress(uuid, addressRequest);
    }

    @Override
    public void updateField(UUID uuid, String fieldName, String value) {
        service.updateField(uuid, fieldName, value);
    }

    @Override
    public List<AddressResponse> getAddressesWithUser(String userName) {
        return service.getAddressesWithUser(userName);
    }

    @Override
    public List<AddressResponse> getAddressesWithPagination(int limit, int offset) {
        return service.getAddressesWithPagination(limit, offset);
    }

}