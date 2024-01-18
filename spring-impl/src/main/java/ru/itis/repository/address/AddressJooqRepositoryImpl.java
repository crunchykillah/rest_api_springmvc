package ru.itis.repository.address;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.UpdatableRecord;
import org.springframework.stereotype.Repository;
import ru.itis.model.jooq.schema.Tables;
import ru.itis.model.jooq.schema.tables.pojos.AddressEntityPojo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AddressJooqRepositoryImpl implements AddressJooqRepository {

    private final DSLContext jooq;
    @Override
    public Optional<AddressEntityPojo> findById(UUID addressId) {
        return Optional.ofNullable(jooq.select(Tables.ADDRESS_ENTITY.fields())
                .from(Tables.ADDRESS_ENTITY)
                .where(Tables.ADDRESS_ENTITY.ADDRESS_ID.eq(addressId))
                .fetchOneInto(AddressEntityPojo.class));
    }

    @Override
    public List<AddressEntityPojo> findAll() {
        return jooq.select(Tables.ADDRESS_ENTITY.fields())
                .from(Tables.ADDRESS_ENTITY)
                .fetchInto(AddressEntityPojo.class);
    }

    // TODO хз как тут правильно (зачем мы вообще лист передаем???)
    @Override
    public void save(List<AddressEntityPojo> addresses) {
        List<UpdatableRecord<?>> records = addresses.stream()
                .map(entity -> jooq.newRecord(Tables.ADDRESS_ENTITY, entity))
                .collect(Collectors.toList());

        jooq.batchStore(records).execute();
    }

    @Override
    public List<AddressEntityPojo> getAddressesWithUser(String userName) {
        return jooq.select()
                .from(Tables.ADDRESS_ENTITY)
                .join(Tables.USER_ENTITY)
                .on(Tables.ADDRESS_ENTITY.USER_ID.eq(Tables.USER_ENTITY.USER_ID))
                .where(Tables.USER_ENTITY.NAME.eq(userName))
                .fetchInto(AddressEntityPojo.class);
    }

    @Override
    public List<AddressEntityPojo> getAddressesWithPagination(int limit, int offset) {
        return jooq.selectFrom(Tables.ADDRESS_ENTITY)
                .limit(limit)
                .offset(offset)
                .fetchInto(AddressEntityPojo.class);
    }

    @Override
    public void delete(UUID addressId) {
        jooq.deleteFrom(Tables.ADDRESS_ENTITY)
                .where(Tables.ADDRESS_ENTITY.ADDRESS_ID.eq(addressId))
                .execute();
    }

    @Override
    public void update(AddressEntityPojo address) {
        jooq.update(Tables.ADDRESS_ENTITY)
                .set(Tables.ADDRESS_ENTITY.STREET, address.getStreet())
                .set(Tables.ADDRESS_ENTITY.CITY, address.getCity())
                .set(Tables.ADDRESS_ENTITY.ZIP_CODE, address.getZipCode())
                .where(Tables.ADDRESS_ENTITY.ADDRESS_ID.eq(address.getAddressId()))
                .execute();
    }

}
