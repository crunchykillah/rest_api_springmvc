package ru.itis.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.model.product.ProductEntity;

import java.math.BigDecimal;
import java.util.UUID;
@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {

    @Query("SELECT SUM(o.totalPrice) FROM ProductEntity p JOIN p.orders o WHERE p.productId = :id")
    BigDecimal findTotalOrderPriceByProductId(@Param("id") UUID id);
}