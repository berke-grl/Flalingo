package com.example.flalingo.Repository;

import com.example.flalingo.Entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserInfoRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UserInfoRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<UserInfo> getByName(String username) {
        String sql = "Select * From \"UserInfo\" Where \"name\" = :name";
        Map<String, String> param = new HashMap<>();
        param.put("name", username);

        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(UserInfo.class)));
    }

    public void save(UserInfo userInfo) {
        String sql = "Insert Into \"UserInfo\"(\"name\", \"email\", \"password\", \"roles\") Values(:name, :email, :password, :roles)";
        Map<String, Object> params = new HashMap<>();
        params.put("name", userInfo.getName());
        params.put("email", userInfo.getEmail());
        params.put("password", userInfo.getPassword());
        params.put("roles", userInfo.getRoles());

        jdbcTemplate.update(sql, params);
    }
}
