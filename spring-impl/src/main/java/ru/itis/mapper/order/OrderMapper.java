package ru.itis.mapper.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.dto.request.order.OrderRequest;
import ru.itis.dto.response.order.OrderResponse;
import ru.itis.model.order.OrderEntity;
import ru.itis.model.user.UserEntity;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "userEntity", source = "orderRequest.userId")
    @Mapping(target = "products", ignore = true)
    OrderEntity toEntity(OrderRequest orderRequest);

    @Mapping(target = "userId", expression =  "java(orderEntity.getUserEntity().getUserId())")
    OrderResponse toResponse(OrderEntity orderEntity);
    default UserEntity map(UUID userId) {
        if (userId == null) {
            return null;
        }
        return UserEntity.builder()
                .userId(userId)
                .build();
    }
}
