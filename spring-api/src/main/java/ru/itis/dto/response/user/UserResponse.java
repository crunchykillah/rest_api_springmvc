package ru.itis.dto.response.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model for UserResponse")
public record UserResponse(
        @ApiModelProperty(value = "Name") String name,
        @ApiModelProperty(value = "Phone") String phone
) {
}