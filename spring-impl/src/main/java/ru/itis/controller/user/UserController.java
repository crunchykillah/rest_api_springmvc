package ru.itis.controller.user;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.user.UserApi;
import ru.itis.dto.request.user.UserRequest;
import ru.itis.dto.response.user.UserResponse;
import ru.itis.service.user.UserService;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService service;
    @Override
    public UserResponse getById(UUID uuid) {
        return service.getById(uuid);
    }

    @Override
    public Set<UserResponse> getAll(int page,int size,String sort) {
        return service.getAll(page, size, sort);
    }


    @Override
    public UUID create(UserRequest userRequest) {
        return service.create(userRequest);
    }

    @Override
    public void delete(UUID uuid) {
        service.delete(uuid);

    }

    @Override
    public void update(UUID uuid, UserRequest userRequest) {
        service.updateUser(uuid, userRequest);

    }

    @Override
    public void updateField(UUID uuid, String fieldName, String value) {
        service.updateField(uuid, fieldName, value);
    }
}
