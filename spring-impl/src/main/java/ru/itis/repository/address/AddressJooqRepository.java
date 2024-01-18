package ru.itis.repository.address;

import ru.itis.model.jooq.schema.tables.pojos.AddressEntityPojo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AddressJooqRepository {
    public Optional<AddressEntityPojo> findById(UUID addressId);
    public List<AddressEntityPojo> findAll();
    public void save(List<AddressEntityPojo> addresses);
    public List<AddressEntityPojo> getAddressesWithUser(String userName);
    public List<AddressEntityPojo> getAddressesWithPagination(int limit, int offset);
    public void delete(UUID addressId);
    public void update(AddressEntityPojo address);



}
