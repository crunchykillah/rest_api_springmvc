package ru.itis.repository.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.model.user.UserEntity;

import java.util.UUID;
@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    Page<UserEntity> findAll(Pageable pageable);

    @Query("SELECT u.address.street FROM UserEntity u WHERE u.userId = :id")
    String findStreetByUserId(@Param("id") UUID id);
}
