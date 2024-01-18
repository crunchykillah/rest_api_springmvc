package ru.itis.mapper.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.dto.request.product.ProductRequest;
import ru.itis.dto.response.product.ProductResponse;
import ru.itis.model.product.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "orders", ignore = true)
    ProductEntity toEntity(ProductRequest productRequest);

    ProductResponse toResponse(ProductEntity productEntity);
}
