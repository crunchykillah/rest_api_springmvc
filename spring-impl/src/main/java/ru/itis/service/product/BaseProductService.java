package ru.itis.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.product.ProductRequest;
import ru.itis.dto.response.product.ProductResponse;
import ru.itis.exception.NotFoundServiceException;
import ru.itis.exception.product.ProductNotFoundException;
import ru.itis.exception.ServiceException;
import ru.itis.mapper.product.ProductMapper;
import ru.itis.model.product.ProductEntity;
import ru.itis.repository.product.ProductJpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseProductService implements ProductService {

    private final ProductJpaRepository repository;
    private final ProductMapper mapper;

    @Override
    public ProductResponse getById(UUID uuid) {
        return mapper.toResponse(
                repository.findById(uuid)
                        .orElseThrow(() -> new ProductNotFoundException(uuid))
        );
    }

    @Override
    public Set<ProductResponse> getAll() {
        List<ProductEntity> productEntities = repository.findAll();
        if (productEntities.isEmpty()) {
            throw new NotFoundServiceException("No products found");
        }
        return productEntities.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public UUID create(ProductRequest productRequest) {
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName(productRequest.name());
        newProduct.setPrice(productRequest.price());
        ProductEntity savedProduct = repository.save(newProduct);
        if (savedProduct == null) {
            throw new ServiceException("Failed to create product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return savedProduct.getProductId();
    }

    @Override
    public void updateField(UUID uuid, String fieldName, String value) {
        ProductEntity existingProduct = repository.findById(uuid)
                .orElseThrow(() -> new ProductNotFoundException(uuid));

        ProductEntity updatedProduct = ProductEntity.builder()
                .productId(existingProduct.getProductId())
                .orders(existingProduct.getOrders())
                .name(fieldName.equals("name") ? value : existingProduct.getName())
                .price(fieldName.equals("price") ? new BigDecimal(value) : existingProduct.getPrice())
                .build();

        repository.save(updatedProduct);
    }

    @Override
    public void updateProduct(UUID uuid, ProductRequest productRequest) {
        ProductEntity existingProduct = repository.findById(uuid)
                .orElseThrow(() -> new ProductNotFoundException(uuid));

        ProductEntity updatedProduct = ProductEntity.builder()
                .productId(existingProduct.getProductId())
                .orders(existingProduct.getOrders())
                .name(productRequest.name() != null ? productRequest.name() : existingProduct.getName())
                .price(productRequest.price() != null ? productRequest.price() : existingProduct.getPrice())
                .build();

        repository.save(updatedProduct);
    }

    @Override
    public void delete(UUID uuid) {
        ProductEntity existingProduct = repository.findById(uuid)
                .orElseThrow(() -> new ProductNotFoundException(uuid));

        repository.delete(existingProduct);
    }
}