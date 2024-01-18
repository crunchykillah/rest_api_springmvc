package ru.itis.mapper.address;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.dto.request.address.AddressRequest;
import ru.itis.dto.response.address.AddressResponse;
import ru.itis.model.jooq.schema.tables.pojos.UserEntityPojo;
import ru.itis.model.jooq.schema.tables.pojos.AddressEntityPojo;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface JooqAddressMapper {

    @Mapping(target = "addressId", ignore = true)
    @Mapping(target = "userId", source = "addressRequest.userId")
    AddressEntityPojo toEntity(AddressRequest addressRequest);

    @Mapping(target = "userId", expression =  "java(addressEntity.getUserId())")
    AddressResponse toResponse(AddressEntityPojo addressEntity);

    default UserEntityPojo map(UUID userId) {
        if (userId == null) {
            return null;
        }
        UserEntityPojo user = new UserEntityPojo();
        user.setUserId(userId);
        return user;
    }

}
