package ru.itis.model.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.model.user.UserEntity;

import javax.persistence.*;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "address_entity")
public class AddressEntity {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private UUID addressId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

}