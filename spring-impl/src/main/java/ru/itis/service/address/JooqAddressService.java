package ru.itis.service.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.address.AddressRequest;
import ru.itis.dto.response.address.AddressResponse;
import ru.itis.exception.NotFoundServiceException;
import ru.itis.exception.address.AddressNotFoundException;
import ru.itis.mapper.address.JooqAddressMapper;
import ru.itis.model.jooq.schema.tables.pojos.AddressEntityPojo;
import ru.itis.repository.address.AddressJooqRepositoryImpl;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JooqAddressService implements AddressService {

    private final AddressJooqRepositoryImpl repository;
    private final JooqAddressMapper mapper;

    @Override
    public AddressResponse getById(UUID uuid) {
        return mapper.toResponse(
                repository.findById(uuid)
                        .orElseThrow(() -> new AddressNotFoundException(uuid))
        );
    }

    @Override
    public Set<AddressResponse> getAll() {
        List<AddressEntityPojo> addressEntities = repository.findAll();
        if (addressEntities.isEmpty()) {
            throw new NotFoundServiceException("No addresses found");
        }
        return addressEntities.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public UUID create(AddressRequest addressRequest) {
        AddressEntityPojo newAddress = mapper.toEntity(addressRequest);
        repository.save(Collections.singletonList(newAddress));
        return newAddress.getAddressId();
    }

    @Override
    public void updateField(UUID uuid, String fieldName, String value) {
        AddressEntityPojo existingAddress = repository.findById(uuid)
                .orElseThrow(() -> new AddressNotFoundException(uuid));

        switch (fieldName) {
            case "street":
                existingAddress.setStreet(value);
                break;
            case "city":
                existingAddress.setCity(value);
                break;
            case "zipCode":
                existingAddress.setZipCode(value);
                break;
        }

        repository.update(existingAddress);
    }

    @Override
    public void updateAddress(UUID uuid, AddressRequest addressRequest) {
        AddressEntityPojo existingAddress = repository.findById(uuid)
                .orElseThrow(() -> new AddressNotFoundException(uuid));

        existingAddress.setStreet(addressRequest.street() != null ? addressRequest.street() : existingAddress.getStreet());
        existingAddress.setCity(addressRequest.city() != null ? addressRequest.city() : existingAddress.getCity());
        existingAddress.setZipCode(addressRequest.zipCode() != null ? addressRequest.zipCode() : existingAddress.getZipCode());

        repository.update(existingAddress);
    }

    @Override
    public void delete(UUID uuid) {
        repository.delete(uuid);
    }

    public List<AddressResponse> getAddressesWithUser(String userName) {
        List<AddressEntityPojo> addressEntities = repository.getAddressesWithUser(userName);
        return addressEntities.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<AddressResponse> getAddressesWithPagination(int limit, int offset) {
        List<AddressEntityPojo> addressEntities = repository.getAddressesWithPagination(limit, offset);
        return addressEntities.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

}
