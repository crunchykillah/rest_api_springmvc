package ru.itis.api.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.product.ProductRequest;
import ru.itis.dto.response.product.ProductResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Products", value = "Product")
@RequestMapping("/api/v1/products")
public interface ProductApi {

    @ApiOperation(value = "Get product by ID", nickname = "product-get-by-id", response = ProductResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product found", response = ProductResponse.class),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/{product-id}")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse getById(@PathVariable("product-id") UUID uuid);

    @ApiOperation(value = "Get all products", nickname = "product-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Products found", response = Set.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    Set<ProductResponse> getAll();

    @ApiOperation(value = "Create product", nickname = "product-create", response = ProductResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product created", response = UUID.class),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@RequestBody ProductRequest productRequest);

    @ApiOperation(value = "Delete product", nickname = "product-delete")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Product deleted"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @DeleteMapping("/{product-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("product-id") UUID uuid);

    @ApiOperation(value = "Update product", nickname = "product-update")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Product updated"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PutMapping("/{product-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable("product-id") UUID uuid, @RequestBody ProductRequest productRequest);

    @ApiOperation(value = "Update product field", nickname = "product-update-field")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Product field updated"),
            @ApiResponse(code = 400, message = "Invalid field name error"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PatchMapping("/{product-id}/{field-name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateField(@PathVariable("product-id") UUID uuid, @PathVariable("field-name") String fieldName, @RequestParam String value);
}
