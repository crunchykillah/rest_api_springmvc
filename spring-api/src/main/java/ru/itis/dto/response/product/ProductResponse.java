package ru.itis.dto.response.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel(description = "Model for ProductResponse")
public record ProductResponse(
        @ApiModelProperty(value = "Name") String name,
        @ApiModelProperty(value = "Price") BigDecimal price
) {
}