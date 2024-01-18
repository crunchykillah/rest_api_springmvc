package ru.itis.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.model.address.AddressEntity;

import java.util.UUID;

//@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity, UUID> {
    @Query("SELECT a.userEntity.name FROM AddressEntity a WHERE a.addressId = :id")
    String findUserNameByAddressId(@Param("id") UUID id);
}