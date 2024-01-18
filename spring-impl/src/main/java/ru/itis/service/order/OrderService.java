package ru.itis.service.order;

import ru.itis.dto.request.order.OrderRequest;
import ru.itis.dto.response.order.OrderResponse;

import java.util.Set;
import java.util.UUID;

public interface OrderService {
    public OrderResponse getById(UUID uuid);
    public Set<OrderResponse> getAll();
    public UUID create(OrderRequest orderRequest);
    public void updateField(UUID uuid, String fieldName, String value);
    public void updateOrder(UUID uuid, OrderRequest orderRequest);
    public void delete(UUID uuid);
}
