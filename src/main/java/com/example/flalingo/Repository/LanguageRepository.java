package com.example.flalingo.Repository;

import com.example.flalingo.Entity.Language;
import com.example.flalingo.Entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LanguageRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public LanguageRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Language> getAll() {
        List<Language> list = jdbcTemplate.query("Select * From \"Language\"", BeanPropertyRowMapper.newInstance(Language.class));
        return list;
    }

    public Language getById(int id) {
        String sql = "Select * From \"Language\" Where \"id\" = :searchedId";
        Map<String, Integer> param = new HashMap<>();
        param.put("searchedId", id);

        return jdbcTemplate.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(Language.class));
    }

    public boolean save(Language language) {
        String sql = "Insert Into \"Language\"(\"language\") Values(:language)";
        Map<String, Object> param = new HashMap<>();
        param.put("language", language.getLanguage());

        return jdbcTemplate.update(sql, param) == 1;
    }

    public boolean deleteById(int id) {
        String sql = "Delete From \"Language\" Where \"id\" = :id";
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);

        return jdbcTemplate.update(sql, param) == 1;
    }
}
