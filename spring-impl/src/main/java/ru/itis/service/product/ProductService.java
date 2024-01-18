package ru.itis.service.product;

import ru.itis.dto.request.product.ProductRequest;
import ru.itis.dto.response.product.ProductResponse;

import java.util.Set;
import java.util.UUID;

public interface ProductService {
    public ProductResponse getById(UUID uuid);
    public Set<ProductResponse> getAll();
    public UUID create(ProductRequest productRequest);
    public void updateField(UUID uuid, String fieldName, String value);
    public void updateProduct(UUID uuid, ProductRequest productRequest);
    public void delete(UUID uuid);
}
