package ru.itis.dto.request.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel(description = "Model for creating ProductRequest")
public record ProductRequest(
        @ApiModelProperty(value = "Name") String name,
        @ApiModelProperty(value = "Price") BigDecimal price
) {
}