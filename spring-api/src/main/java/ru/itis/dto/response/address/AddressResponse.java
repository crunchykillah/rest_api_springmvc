package ru.itis.dto.response.address;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Model for AddressResponse")
public record AddressResponse(
        @ApiModelProperty(value = "Address ID") UUID addressId,
        @ApiModelProperty(value = "User ID") UUID userId,
        @ApiModelProperty(value = "Street") String street,
        @ApiModelProperty(value = "City") String city,
        @ApiModelProperty(value = "Postal Code") String zipCode
) {
}