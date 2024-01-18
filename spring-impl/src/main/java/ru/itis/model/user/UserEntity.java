package ru.itis.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.model.address.AddressEntity;
import ru.itis.model.order.OrderEntity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_entity")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID userId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "userEntity")
    private Set<OrderEntity> orderEntities;

    @OneToOne(mappedBy = "userEntity")
    private AddressEntity address;

}