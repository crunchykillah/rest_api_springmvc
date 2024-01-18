/*
 * This file is generated by jOOQ.
 */
package ru.itis.model.jooq.schema.tables.records;


import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import ru.itis.model.jooq.schema.tables.UserEntity;
import ru.itis.model.jooq.schema.tables.pojos.UserEntityPojo;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserEntityRecord extends UpdatableRecordImpl<UserEntityRecord> implements Record3<UUID, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.user_entity.user_id</code>.
     */
    public void setUserId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.user_entity.user_id</code>.
     */
    public UUID getUserId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.user_entity.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.user_entity.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.user_entity.phone</code>.
     */
    public void setPhone(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.user_entity.phone</code>.
     */
    public String getPhone() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<UUID, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return UserEntity.USER_ENTITY.USER_ID;
    }

    @Override
    public Field<String> field2() {
        return UserEntity.USER_ENTITY.NAME;
    }

    @Override
    public Field<String> field3() {
        return UserEntity.USER_ENTITY.PHONE;
    }

    @Override
    public UUID component1() {
        return getUserId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getPhone();
    }

    @Override
    public UUID value1() {
        return getUserId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getPhone();
    }

    @Override
    public UserEntityRecord value1(UUID value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserEntityRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public UserEntityRecord value3(String value) {
        setPhone(value);
        return this;
    }

    @Override
    public UserEntityRecord values(UUID value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserEntityRecord
     */
    public UserEntityRecord() {
        super(UserEntity.USER_ENTITY);
    }

    /**
     * Create a detached, initialised UserEntityRecord
     */
    public UserEntityRecord(UUID userId, String name, String phone) {
        super(UserEntity.USER_ENTITY);

        setUserId(userId);
        setName(name);
        setPhone(phone);
    }

    /**
     * Create a detached, initialised UserEntityRecord
     */
    public UserEntityRecord(UserEntityPojo value) {
        super(UserEntity.USER_ENTITY);

        if (value != null) {
            setUserId(value.getUserId());
            setName(value.getName());
            setPhone(value.getPhone());
        }
    }
}
