package ru.itis.dto.response.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@ApiModel(description = "Model for OrderResponse")
public record OrderResponse(
        @ApiModelProperty(value = "Order ID") UUID orderId,
        @ApiModelProperty(value = "User ID") UUID userId,
        @ApiModelProperty(value = "Order Date") Timestamp orderDate,
        @ApiModelProperty(value = "Total Price") BigDecimal totalPrice
) {
}