/*
 * This file is generated by jOOQ.
 */
package ru.itis.model.jooq.schema.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import ru.itis.model.entity.Entity;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderEntityPojo extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID orderId;
    private UUID userId;
    private LocalDateTime orderDate;
    private BigDecimal totalPrice;

    public OrderEntityPojo() {}

    public OrderEntityPojo(OrderEntityPojo value) {
        this.orderId = value.orderId;
        this.userId = value.userId;
        this.orderDate = value.orderDate;
        this.totalPrice = value.totalPrice;
    }

    public OrderEntityPojo(
        UUID orderId,
        UUID userId,
        LocalDateTime orderDate,
        BigDecimal totalPrice
    ) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    /**
     * Getter for <code>public.order_entity.order_id</code>.
     */
    public UUID getOrderId() {
        return this.orderId;
    }

    /**
     * Setter for <code>public.order_entity.order_id</code>.
     */
    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter for <code>public.order_entity.user_id</code>.
     */
    public UUID getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>public.order_entity.user_id</code>.
     */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>public.order_entity.order_date</code>.
     */
    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    /**
     * Setter for <code>public.order_entity.order_date</code>.
     */
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Getter for <code>public.order_entity.total_price</code>.
     */
    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Setter for <code>public.order_entity.total_price</code>.
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final OrderEntityPojo other = (OrderEntityPojo) obj;
        if (this.orderId == null) {
            if (other.orderId != null)
                return false;
        }
        else if (!this.orderId.equals(other.orderId))
            return false;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        if (this.orderDate == null) {
            if (other.orderDate != null)
                return false;
        }
        else if (!this.orderDate.equals(other.orderDate))
            return false;
        if (this.totalPrice == null) {
            if (other.totalPrice != null)
                return false;
        }
        else if (!this.totalPrice.equals(other.totalPrice))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.orderId == null) ? 0 : this.orderId.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.orderDate == null) ? 0 : this.orderDate.hashCode());
        result = prime * result + ((this.totalPrice == null) ? 0 : this.totalPrice.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("OrderEntityPojo (");

        sb.append(orderId);
        sb.append(", ").append(userId);
        sb.append(", ").append(orderDate);
        sb.append(", ").append(totalPrice);

        sb.append(")");
        return sb.toString();
    }
}
