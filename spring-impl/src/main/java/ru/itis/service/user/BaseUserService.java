package ru.itis.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.user.UserRequest;
import ru.itis.dto.response.user.UserResponse;
import ru.itis.exception.NotFoundServiceException;
import ru.itis.exception.ServiceException;
import ru.itis.exception.UserNotFoundException;
import ru.itis.mapper.user.UserMapper;
import ru.itis.model.user.UserEntity;
import ru.itis.repository.user.UserJpaRepository;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseUserService implements UserService {

    private final UserJpaRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponse getById(UUID uuid) {
        System.out.println("getById repository");
        return mapper.toResponse(
                repository.findById(uuid)
                        .orElseThrow(() -> new UserNotFoundException(uuid))
        );
    }

    @Override
    public Set<UserResponse> getAll(int page,int size,String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc(sort)));
        Page<UserEntity> userEntities = repository.findAll(pageable);
        if (userEntities.isEmpty()) {
            throw new NotFoundServiceException("No users found");
        }
        return userEntities.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public UUID create(UserRequest userRequest) {
        UserEntity newUser = new UserEntity();
        newUser.setName(userRequest.name());
        newUser.setPhone(userRequest.phone());
        UserEntity savedUser = repository.save(newUser);
        if (savedUser == null) {
            throw new ServiceException("Failed to create user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return savedUser.getUserId();
    }

    @Override
    public void updateField(UUID uuid, String fieldName, String value) {
        UserEntity existingUser = repository.findById(uuid)
                .orElseThrow(() -> new UserNotFoundException(uuid));

        UserEntity updatedUser = UserEntity.builder()
                .userId(existingUser.getUserId())
                .address(existingUser.getAddress())
                .orderEntities(existingUser.getOrderEntities())
                .name(fieldName.equals("name") ? value : existingUser.getName())
                .phone(fieldName.equals("phone") ? value : existingUser.getPhone())
                .build();

        repository.save(updatedUser);
    }

    @Override
    public void updateUser(UUID uuid, UserRequest userRequest) {
        UserEntity existingUser = repository.findById(uuid)
                .orElseThrow(() -> new UserNotFoundException(uuid));

        UserEntity updatedUser = UserEntity.builder()
                .userId(existingUser.getUserId())
                .address(existingUser.getAddress())
                .orderEntities(existingUser.getOrderEntities())
                .name(userRequest.name() != null ? userRequest.name() : existingUser.getName())
                .phone(userRequest.phone() != null ? userRequest.phone() : existingUser.getPhone())
                .build();

        repository.save(updatedUser);
    }

    @Override
    public void delete(UUID uuid) {
        UserEntity existingUser = repository.findById(uuid)
                .orElseThrow(() -> new UserNotFoundException(uuid));

        repository.delete(existingUser);
    }
}
