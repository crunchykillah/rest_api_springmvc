package ru.itis.dto.request.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@ApiModel(description = "Model for creating OrderRequest")
public record OrderRequest(
        @ApiModelProperty(value = "User ID") UUID userId,
        @ApiModelProperty(value = "Order Date") Timestamp orderDate,
        @ApiModelProperty(value = "Total Price") BigDecimal totalPrice
) {
}