package ru.itis.controller.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.order.OrderApi;
import ru.itis.dto.request.order.OrderRequest;
import ru.itis.dto.response.order.OrderResponse;
import ru.itis.service.order.BaseOrderService;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final BaseOrderService service;

    @Override
    public OrderResponse getById(UUID uuid) {
        return service.getById(uuid);
    }

    @Override
    public Set<OrderResponse> getAll() {
        return service.getAll();
    }

    @Override
    public UUID create(OrderRequest orderRequest) {
        return service.create(orderRequest);
    }

    @Override
    public void delete(UUID uuid) {
        service.delete(uuid);
    }

    @Override
    public void update(UUID uuid, OrderRequest orderRequest) {
        service.updateOrder(uuid, orderRequest);
    }

    @Override
    public void updateField(UUID uuid, String fieldName, String value) {
        service.updateField(uuid, fieldName, value);
    }
}
