package ru.itis.mapper.address;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.dto.request.address.AddressRequest;
import ru.itis.dto.response.address.AddressResponse;
import ru.itis.model.address.AddressEntity;
import ru.itis.model.user.UserEntity;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "addressId", ignore = true)
    @Mapping(target = "userEntity", source = "addressRequest.userId")
    AddressEntity toEntity(AddressRequest addressRequest);

    @Mapping(target = "userId", expression =  "java(addressEntity.getUserEntity().getUserId())")
    AddressResponse toResponse(AddressEntity addressEntity);

    default UserEntity map(UUID userId) {
        if (userId == null) {
            return null;
        }
        return UserEntity.builder()
                .userId(userId)
                .build();
    }

}

