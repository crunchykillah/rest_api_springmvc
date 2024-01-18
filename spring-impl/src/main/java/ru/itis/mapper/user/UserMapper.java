package ru.itis.mapper.user;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.dto.request.user.UserRequest;
import ru.itis.dto.response.user.UserResponse;
import ru.itis.model.user.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "orderEntities", ignore = true)
    @Mapping(target = "address", ignore = true)
    UserEntity toEntity(UserRequest userRequest);

    UserResponse toResponse(UserEntity userEntity);
}
