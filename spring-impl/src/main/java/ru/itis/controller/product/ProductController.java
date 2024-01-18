package ru.itis.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.product.ProductApi;
import ru.itis.dto.request.product.ProductRequest;
import ru.itis.dto.response.product.ProductResponse;
import ru.itis.service.product.BaseProductService;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final BaseProductService service;

    @Override
    public ProductResponse getById(UUID uuid) {
        return service.getById(uuid);
    }

    @Override
    public Set<ProductResponse> getAll() {
        return service.getAll();
    }

    @Override
    public UUID create(ProductRequest productRequest) {
        return service.create(productRequest);
    }

    @Override
    public void delete(UUID uuid) {
        service.delete(uuid);
    }

    @Override
    public void update(UUID uuid, ProductRequest productRequest) {
        service.updateProduct(uuid, productRequest);
    }

    @Override
    public void updateField(UUID uuid, String fieldName, String value) {
        service.updateField(uuid, fieldName, value);
    }
}
