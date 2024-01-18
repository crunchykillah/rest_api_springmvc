package ru.itis.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.model.order.OrderEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product_entity")
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(name = "product_id", nullable = false, updatable = false)
    private UUID productId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    private List<OrderEntity> orders;

}
