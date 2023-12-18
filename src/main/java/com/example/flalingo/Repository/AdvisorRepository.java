package com.example.flalingo.Repository;

import com.example.flalingo.Entity.Advisor;
import com.example.flalingo.Entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdvisorRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public AdvisorRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Advisor> getAll() {
        List<Advisor> list = jdbcTemplate.query("Select * From \"Advisor\"", BeanPropertyRowMapper.newInstance(Advisor.class));
        return list;
    }

    public Advisor getById(int id) {
        String sql = "Select * From \"Advisor\" Where \"id\" = :searchedId";
        Map<String, Integer> param = new HashMap<>();
        param.put("searchedId", id);

        return jdbcTemplate.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(Advisor.class));
    }

    public boolean save(Advisor advisor) {
        String sql = "Insert Into \"Advisor\"(\"teacher_id\", \"student_id\", \"language_id\", \"name\") Values(:teacher_id, :student_id, :language_id, :name)";
        Map<String, Object> param = new HashMap<>();
        param.put("teacher_id", advisor.getTeacher_id());
        param.put("student_id", advisor.getStudent_id());
        param.put("language_id", advisor.getLanguage_id());
        param.put("name", advisor.getName());

        return jdbcTemplate.update(sql, param) == 1;
    }

    public boolean deleteById(int id) {
        String sql = "Delete From \"Advisor\" Where \"id\" = :id";
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);

        return jdbcTemplate.update(sql, param) == 1;
    }
}
