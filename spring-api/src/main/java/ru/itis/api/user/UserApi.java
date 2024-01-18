package ru.itis.api.user;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.user.UserRequest;
import ru.itis.dto.response.user.UserResponse;

import java.util.Set;
import java.util.UUID;

@Api(tags = "Users", value = "User")
@RequestMapping("/api/v1/users")
public interface UserApi {

    @ApiOperation(value = "Get user by ID", nickname = "user-get-by-id", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found", response = UserResponse.class),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    UserResponse getById(@PathVariable("user-id") UUID uuid);

    @ApiOperation(value = "Get all users", nickname = "user-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users found", response = Set.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    Set<UserResponse> getAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "name") String sort);


    @ApiOperation(value = "Create user", nickname = "user-create", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User created", response = UUID.class),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@RequestBody UserRequest userRequest);

    @ApiOperation(value = "Delete user", nickname = "user-delete")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "User deleted"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @DeleteMapping("/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("user-id") UUID uuid);

    @ApiOperation(value = "Update user", nickname = "user-update")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "User updated"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PutMapping("/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable("user-id") UUID uuid, @RequestBody UserRequest userRequest);

    @ApiOperation(value = "Update user field", nickname = "user-update-field")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "User field updated"),
            @ApiResponse(code = 400, message = "Invalid field name error"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PatchMapping("/{user-id}/{field-name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateField(@PathVariable("user-id") UUID uuid, @PathVariable("field-name") String fieldName, @RequestParam String value);
}