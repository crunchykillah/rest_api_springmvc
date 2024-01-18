package ru.itis.repository.user;


import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.itis.model.user.UserEntity;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private final static String SQL_GET_BY_ID = "select * from user_entity where uuid = '%s'";
    private final static String SQL_GET_ALL = "select * from user_entity";
    private final static String SQL_INSERT = "insert into user_entity (name, phone) values (?, ?)";
    private final static String SQL_UPDATE = "update user_entity set name = ?, phone = ? where uuid = ?";
    private final static String SQL_DELETE = "delete from user_entity where uuid = ?";
    private final static String SQL_UPDATE_FIELD = "update user_entity set %s = ? where uuid = ?";


    private RowMapper<UserEntity> rowMapper = (rs, rowNum) -> UserEntity.builder()
            .name(rs.getString("name"))
            .phone(rs.getString("phone"))
            .userId(rs.getObject("uuid", UUID.class))
            .build();

    @Override
    public Optional<UserEntity> findById(UUID uuid) {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_BY_ID.formatted(uuid), rowMapper)) {
            return stream.findAny();
        }
    }

    @Override
    public List<UserEntity> findAll() {
        try (val stream = jdbcTemplate.queryForStream(SQL_GET_ALL, rowMapper)) {
            return stream.collect(Collectors.toList());
        }
    }
    @Override
    public UserEntity create(UserEntity user) {
        jdbcTemplate.update(SQL_INSERT, user.getName(), user.getPhone());
        return user;
    }

    @Override
    public void update(UserEntity user) {
        jdbcTemplate.update(SQL_UPDATE, user.getName(), user.getPhone(), user.getUserId());
    }

    @Override
    public void delete(UUID uuid) {
        jdbcTemplate.update(SQL_DELETE, uuid);
    }

    @Override
    public void updateField(UserEntity user, String fieldName) {
        jdbcTemplate.update(SQL_UPDATE_FIELD.formatted(fieldName), user.getName(), user.getPhone(), user.getUserId());
    }
}
