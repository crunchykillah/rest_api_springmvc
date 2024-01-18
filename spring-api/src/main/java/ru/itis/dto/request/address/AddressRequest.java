package ru.itis.dto.request.address;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;
@ApiModel(description = "Model for creating AddressRequest")
public record AddressRequest(
        @ApiModelProperty(value = "User ID") UUID userId,
        @ApiModelProperty(value = "Street") String street,
        @ApiModelProperty(value = "City") String city,
        @ApiModelProperty(value = "Postal Code") String zipCode
) {
}