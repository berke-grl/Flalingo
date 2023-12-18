package com.example.flalingo.Repository;

import com.example.flalingo.Entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TeacherRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public TeacherRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Teacher> getAll() {
        List<Teacher> list = jdbcTemplate.query("Select * From \"Teacher\"", BeanPropertyRowMapper.newInstance(Teacher.class));
        return list;
    }

    public Teacher getById(int id) {
        String sql = "Select * From \"Teacher\" Where \"id\" = :searchedId";
        Map<String, Integer> param = new HashMap<>();
        param.put("searchedId", id);

        return jdbcTemplate.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(Teacher.class));
    }

    public boolean save(Teacher teacher) {
        String sql = "Insert Into \"Teacher\"(\"name\", \"last_name\", \"language_id\") Values(:name, :last_name, :language_id)";
        Map<String, Object> params = new HashMap<>();
        params.put("name", teacher.getName());
        params.put("last_name", teacher.getLastName());
        params.put("language_id", teacher.getLanguageId());

        return jdbcTemplate.update(sql, params) == 1;
    }

    public boolean deleteById(int id) {
        String sql = "Delete From \"Teacher\" Where \"id\" = :id";
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);

        return jdbcTemplate.update(sql, param) == 1;
    }
}
