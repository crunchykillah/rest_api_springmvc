/*
 * This file is generated by jOOQ.
 */
package ru.itis.model.jooq.schema.tables.records;


import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import ru.itis.model.jooq.schema.tables.AddressEntity;
import ru.itis.model.jooq.schema.tables.pojos.AddressEntityPojo;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AddressEntityRecord extends UpdatableRecordImpl<AddressEntityRecord> implements Record5<UUID, UUID, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.address_entity.address_id</code>.
     */
    public void setAddressId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.address_entity.address_id</code>.
     */
    public UUID getAddressId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.address_entity.user_id</code>.
     */
    public void setUserId(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.address_entity.user_id</code>.
     */
    public UUID getUserId() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.address_entity.street</code>.
     */
    public void setStreet(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.address_entity.street</code>.
     */
    public String getStreet() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.address_entity.city</code>.
     */
    public void setCity(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.address_entity.city</code>.
     */
    public String getCity() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.address_entity.zip_code</code>.
     */
    public void setZipCode(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.address_entity.zip_code</code>.
     */
    public String getZipCode() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, UUID, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<UUID, UUID, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return AddressEntity.ADDRESS_ENTITY.ADDRESS_ID;
    }

    @Override
    public Field<UUID> field2() {
        return AddressEntity.ADDRESS_ENTITY.USER_ID;
    }

    @Override
    public Field<String> field3() {
        return AddressEntity.ADDRESS_ENTITY.STREET;
    }

    @Override
    public Field<String> field4() {
        return AddressEntity.ADDRESS_ENTITY.CITY;
    }

    @Override
    public Field<String> field5() {
        return AddressEntity.ADDRESS_ENTITY.ZIP_CODE;
    }

    @Override
    public UUID component1() {
        return getAddressId();
    }

    @Override
    public UUID component2() {
        return getUserId();
    }

    @Override
    public String component3() {
        return getStreet();
    }

    @Override
    public String component4() {
        return getCity();
    }

    @Override
    public String component5() {
        return getZipCode();
    }

    @Override
    public UUID value1() {
        return getAddressId();
    }

    @Override
    public UUID value2() {
        return getUserId();
    }

    @Override
    public String value3() {
        return getStreet();
    }

    @Override
    public String value4() {
        return getCity();
    }

    @Override
    public String value5() {
        return getZipCode();
    }

    @Override
    public AddressEntityRecord value1(UUID value) {
        setAddressId(value);
        return this;
    }

    @Override
    public AddressEntityRecord value2(UUID value) {
        setUserId(value);
        return this;
    }

    @Override
    public AddressEntityRecord value3(String value) {
        setStreet(value);
        return this;
    }

    @Override
    public AddressEntityRecord value4(String value) {
        setCity(value);
        return this;
    }

    @Override
    public AddressEntityRecord value5(String value) {
        setZipCode(value);
        return this;
    }

    @Override
    public AddressEntityRecord values(UUID value1, UUID value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AddressEntityRecord
     */
    public AddressEntityRecord() {
        super(AddressEntity.ADDRESS_ENTITY);
    }

    /**
     * Create a detached, initialised AddressEntityRecord
     */
    public AddressEntityRecord(UUID addressId, UUID userId, String street, String city, String zipCode) {
        super(AddressEntity.ADDRESS_ENTITY);

        setAddressId(addressId);
        setUserId(userId);
        setStreet(street);
        setCity(city);
        setZipCode(zipCode);
    }

    /**
     * Create a detached, initialised AddressEntityRecord
     */
    public AddressEntityRecord(AddressEntityPojo value) {
        super(AddressEntity.ADDRESS_ENTITY);

        if (value != null) {
            setAddressId(value.getAddressId());
            setUserId(value.getUserId());
            setStreet(value.getStreet());
            setCity(value.getCity());
            setZipCode(value.getZipCode());
        }
    }
}
