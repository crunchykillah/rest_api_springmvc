package ru.itis.repository.user;


import ru.itis.model.user.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<UserEntity> findById(UUID uuid);
    List<UserEntity> findAll();
    UserEntity create(UserEntity user);
    void update(UserEntity user);
    void delete(UUID uuid);
    void updateField(UserEntity user, String fieldName);
}
