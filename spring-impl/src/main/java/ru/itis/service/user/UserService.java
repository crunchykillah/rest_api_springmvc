package ru.itis.service.user;


import ru.itis.dto.request.user.UserRequest;
import ru.itis.dto.response.user.UserResponse;

import java.util.Set;
import java.util.UUID;

public interface UserService {
    UserResponse getById(UUID uuid);

    public Set<UserResponse> getAll(int page,int size,String sort);

    UUID create(UserRequest userRequest);

    void updateField(UUID uuid, String fieldName, String value);

    void updateUser(UUID uuid, UserRequest userRequest);

    void delete(UUID uuid);
}
