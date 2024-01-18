package ru.itis.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.order.OrderRequest;
import ru.itis.dto.response.order.OrderResponse;
import ru.itis.exception.NotFoundServiceException;
import ru.itis.exception.ServiceException;
import ru.itis.exception.order.OrderNotFoundException;
import ru.itis.mapper.order.OrderMapper;
import ru.itis.model.order.OrderEntity;
import ru.itis.repository.order.OrderJpaRepository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseOrderService implements OrderService {

    private final OrderJpaRepository repository;
    private final OrderMapper mapper;

    @Override
    public OrderResponse getById(UUID uuid) {
        return mapper.toResponse(
                repository.findById(uuid)
                        .orElseThrow(() -> new OrderNotFoundException(uuid))
        );
    }

    @Override
    public Set<OrderResponse> getAll() {
        List<OrderEntity> orderEntities = repository.findAll();
        if (orderEntities.isEmpty()) {
            throw new NotFoundServiceException("No orders found");
        }
        return orderEntities.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public UUID create(OrderRequest orderRequest) {
        OrderEntity newOrder = mapper.toEntity(orderRequest);
        OrderEntity savedOrder = repository.save(newOrder);
        if (savedOrder == null) {
            throw new ServiceException("Failed to create order", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return savedOrder.getOrderId();
    }

    @Override
    public void updateField(UUID uuid, String fieldName, String value) {
        OrderEntity existingOrder = repository.findById(uuid)
                .orElseThrow(() -> new OrderNotFoundException(uuid));

        OrderEntity updatedOrder = OrderEntity.builder()
                .orderId(existingOrder.getOrderId())
                .userEntity(existingOrder.getUserEntity())
                .products(existingOrder.getProducts())
                .orderDate(fieldName.equals("orderDate") ? Timestamp.valueOf(value) : existingOrder.getOrderDate())
                .totalPrice(fieldName.equals("totalPrice") ? new BigDecimal(value) : existingOrder.getTotalPrice())
                .build();

        repository.save(updatedOrder);
    }

    @Override
    public void updateOrder(UUID uuid, OrderRequest orderRequest) {
        OrderEntity existingOrder = repository.findById(uuid)
                .orElseThrow(() -> new OrderNotFoundException(uuid));

        OrderEntity updatedOrder = OrderEntity.builder()
                .orderId(existingOrder.getOrderId())
                .userEntity(existingOrder.getUserEntity())
                .products(existingOrder.getProducts())
                .orderDate(orderRequest.orderDate() != null ? orderRequest.orderDate() : existingOrder.getOrderDate())
                .totalPrice(orderRequest.totalPrice() != null ? orderRequest.totalPrice() : existingOrder.getTotalPrice())
                .build();

        repository.save(updatedOrder);
    }

    @Override
    public void delete(UUID uuid) {
        OrderEntity existingOrder = repository.findById(uuid)
                .orElseThrow(() -> new OrderNotFoundException(uuid));

        repository.delete(existingOrder);
    }
}