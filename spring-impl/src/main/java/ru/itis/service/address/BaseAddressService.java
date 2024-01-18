package ru.itis.service.address;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.address.AddressRequest;
import ru.itis.dto.response.address.AddressResponse;
import ru.itis.exception.NotFoundServiceException;
import ru.itis.exception.ServiceException;
import ru.itis.exception.address.AddressNotFoundException;
import ru.itis.mapper.address.AddressMapper;
import ru.itis.model.address.AddressEntity;
import ru.itis.repository.address.AddressJpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseAddressService implements AddressService {

    private final AddressJpaRepository repository;
    private final AddressMapper mapper;

    @Override
    public AddressResponse getById(UUID uuid) {
        return mapper.toResponse(
                repository.findById(uuid)
                        .orElseThrow(() -> new AddressNotFoundException(uuid))
        );
    }

    @Override
    public Set<AddressResponse> getAll() {
        List<AddressEntity> addressEntities = repository.findAll();
        if (addressEntities.isEmpty()) {
            throw new NotFoundServiceException("No addresses found");
        }
        return addressEntities.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public UUID create(AddressRequest addressRequest) {
        AddressEntity newAddress = mapper.toEntity(addressRequest);
        AddressEntity savedAddress = repository.save(newAddress);
        if (savedAddress == null) {
            throw new ServiceException("Failed to create address", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return savedAddress.getAddressId();
    }

    @Override
    public void updateField(UUID uuid, String fieldName, String value) {
        AddressEntity existingAddress = repository.findById(uuid)
                .orElseThrow(() -> new AddressNotFoundException(uuid));

        AddressEntity updatedAddress = AddressEntity.builder()
                .addressId(existingAddress.getAddressId())
                .userEntity(existingAddress.getUserEntity())
                .street(fieldName.equals("street") ? value : existingAddress.getStreet())
                .city(fieldName.equals("city") ? value : existingAddress.getCity())
                .zipCode(fieldName.equals("zipCode") ? value : existingAddress.getZipCode())
                .build();

        repository.save(existingAddress);
    }

    @Override
    public void updateAddress(UUID uuid, AddressRequest addressRequest) {
        AddressEntity existingAddress = repository.findById(uuid)
                .orElseThrow(() -> new AddressNotFoundException(uuid));

        existingAddress = AddressEntity.builder()
                .addressId(existingAddress.getAddressId())
                .userEntity(existingAddress.getUserEntity())
                .street(addressRequest.street() != null ? addressRequest.street() : existingAddress.getStreet())
                .city(addressRequest.city() != null ? addressRequest.city() : existingAddress.getCity())
                .zipCode(addressRequest.zipCode() != null ? addressRequest.zipCode() : existingAddress.getZipCode())
                .build();

        repository.save(existingAddress);
    }

    @Override
    public void delete(UUID uuid) {
        AddressEntity existingAddress = repository.findById(uuid)
                .orElseThrow(() -> new AddressNotFoundException(uuid));

        repository.delete(existingAddress);
    }
}
