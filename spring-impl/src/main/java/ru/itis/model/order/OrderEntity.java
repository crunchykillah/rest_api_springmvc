package ru.itis.model.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.model.product.ProductEntity;
import ru.itis.model.user.UserEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order_entity")
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private UUID orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )    private List<ProductEntity> products;

}