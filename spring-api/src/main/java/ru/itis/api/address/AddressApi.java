package ru.itis.api.address;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.address.AddressRequest;
import ru.itis.dto.response.address.AddressResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;
@Api(tags = "Addresses", value = "Address")
@RequestMapping("/api/v1/addresses")
public interface AddressApi {

    @ApiOperation(value = "Get address by ID", nickname = "address-get-by-id", response = AddressResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Address found", response = AddressResponse.class),
            @ApiResponse(code = 404, message = "Address not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/{address-id}")
    @ResponseStatus(HttpStatus.OK)
    AddressResponse getById(@PathVariable("address-id") UUID uuid);

    @ApiOperation(value = "Get all addresses", nickname = "address-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Addresses found", response = Set.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    Set<AddressResponse> getAll();

    @ApiOperation(value = "Create address", nickname = "address-create", response = UUID.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Address created", response = UUID.class),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@RequestBody AddressRequest addressRequest);

    @ApiOperation(value = "Delete address", nickname = "address-delete")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Address deleted"),
            @ApiResponse(code = 404, message = "Address not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @DeleteMapping("/{address-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("address-id") UUID uuid);

    @ApiOperation(value = "Update address", nickname = "address-update")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Address updated"),
            @ApiResponse(code = 400, message = "Validation error"),
            @ApiResponse(code = 404, message = "Address not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PutMapping("/{address-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable("address-id") UUID uuid, @RequestBody AddressRequest addressRequest);

    @ApiOperation(value = "Update address field", nickname = "address-update-field")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Address field updated"),
            @ApiResponse(code = 400, message = "Invalid field name error"),
            @ApiResponse(code = 404, message = "Address not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PatchMapping("/{address-id}/{field-name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateField(@PathVariable("address-id") UUID uuid, @PathVariable("field-name") String fieldName, @RequestParam String value);

    @ApiOperation(value = "Get addresses by user name", nickname = "address-get-by-user", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Addresses found", response = List.class),
            @ApiResponse(code = 404, message = "Addresses not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/user/{user-name}")
    @ResponseStatus(HttpStatus.OK)
    List<AddressResponse> getAddressesWithUser(@PathVariable("user-name") String userName);

    @ApiOperation(value = "Get addresses with pagination", nickname = "address-get-with-pagination", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Addresses found", response = List.class),
            @ApiResponse(code = 404, message = "Addresses not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping("/pagination")
    @ResponseStatus(HttpStatus.OK)
    List<AddressResponse> getAddressesWithPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset);
}
