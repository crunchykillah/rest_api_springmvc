package ru.itis.api.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.order.OrderRequest;
import ru.itis.dto.response.order.OrderResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Orders", value = "Order")
@RequestMapping("/api/v1/orders")
public interface OrderApi {

    @ApiOperation(value = "Get order by ID", nickname = "order-get-by-id", response = OrderResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order found", response = OrderResponse.class),
            @ApiResponse(code = 404, message = "Order not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/{order-id}")
    @ResponseStatus(HttpStatus.OK)
    OrderResponse getById(@PathVariable("order-id") UUID uuid);

    @ApiOperation(value = "Get all orders", nickname = "order-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Orders found", response = Set.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    Set<OrderResponse> getAll();

    @ApiOperation(value = "Create order", nickname = "order-create", response = OrderResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Order created", response = UUID.class),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@RequestBody OrderRequest orderRequest);

    @ApiOperation(value = "Delete order", nickname = "order-delete")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Order deleted"),
            @ApiResponse(code = 404, message = "Order not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @DeleteMapping("/{order-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("order-id") UUID uuid);

    @ApiOperation(value = "Update order", nickname = "order-update")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Order updated"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 404, message = "Order not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PutMapping("/{order-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable("order-id") UUID uuid, @RequestBody OrderRequest orderRequest);

    @ApiOperation(value = "Update order field", nickname = "order-update-field")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Order field updated"),
            @ApiResponse(code = 400, message = "Invalid field name error"),
            @ApiResponse(code = 404, message = "Order not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PatchMapping("/{order-id}/{field-name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateField(@PathVariable("order-id") UUID uuid, @PathVariable("field-name") String fieldName, @RequestParam String value);
}
