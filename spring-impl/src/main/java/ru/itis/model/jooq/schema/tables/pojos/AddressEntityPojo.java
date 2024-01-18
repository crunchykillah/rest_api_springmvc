/*
 * This file is generated by jOOQ.
 */
package ru.itis.model.jooq.schema.tables.pojos;


import java.io.Serializable;
import java.util.UUID;

import ru.itis.model.entity.Entity;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AddressEntityPojo extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID addressId;
    private UUID userId;
    private String street;
    private String city;
    private String zipCode;

    public AddressEntityPojo() {}

    public AddressEntityPojo(AddressEntityPojo value) {
        this.addressId = value.addressId;
        this.userId = value.userId;
        this.street = value.street;
        this.city = value.city;
        this.zipCode = value.zipCode;
    }

    public AddressEntityPojo(
        UUID addressId,
        UUID userId,
        String street,
        String city,
        String zipCode
    ) {
        this.addressId = addressId;
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    /**
     * Getter for <code>public.address_entity.address_id</code>.
     */
    public UUID getAddressId() {
        return this.addressId;
    }

    /**
     * Setter for <code>public.address_entity.address_id</code>.
     */
    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    /**
     * Getter for <code>public.address_entity.user_id</code>.
     */
    public UUID getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>public.address_entity.user_id</code>.
     */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>public.address_entity.street</code>.
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * Setter for <code>public.address_entity.street</code>.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for <code>public.address_entity.city</code>.
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Setter for <code>public.address_entity.city</code>.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for <code>public.address_entity.zip_code</code>.
     */
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     * Setter for <code>public.address_entity.zip_code</code>.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final AddressEntityPojo other = (AddressEntityPojo) obj;
        if (this.addressId == null) {
            if (other.addressId != null)
                return false;
        }
        else if (!this.addressId.equals(other.addressId))
            return false;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        if (this.street == null) {
            if (other.street != null)
                return false;
        }
        else if (!this.street.equals(other.street))
            return false;
        if (this.city == null) {
            if (other.city != null)
                return false;
        }
        else if (!this.city.equals(other.city))
            return false;
        if (this.zipCode == null) {
            if (other.zipCode != null)
                return false;
        }
        else if (!this.zipCode.equals(other.zipCode))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.addressId == null) ? 0 : this.addressId.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.street == null) ? 0 : this.street.hashCode());
        result = prime * result + ((this.city == null) ? 0 : this.city.hashCode());
        result = prime * result + ((this.zipCode == null) ? 0 : this.zipCode.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AddressEntityPojo (");

        sb.append(addressId);
        sb.append(", ").append(userId);
        sb.append(", ").append(street);
        sb.append(", ").append(city);
        sb.append(", ").append(zipCode);

        sb.append(")");
        return sb.toString();
    }
}
