package ru.itis.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.model.order.OrderEntity;

import java.util.UUID;
@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {

    @Query("SELECT o.userEntity.name FROM OrderEntity o WHERE o.orderId = :id")
    String findUserNameByOrderId(@Param("id") UUID id);
}
