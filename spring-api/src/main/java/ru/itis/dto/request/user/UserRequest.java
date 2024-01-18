package ru.itis.dto.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model for creating UserRequest")
public record UserRequest(
        @ApiModelProperty(value = "Name") String name,
        @ApiModelProperty(value = "Phone") String phone
) {
}