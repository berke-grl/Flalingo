package com.example.flalingo.Repository;

import com.example.flalingo.Entity.Language;
import com.example.flalingo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> getAll() {
        List<Student> list = jdbcTemplate.query("Select * From \"Student\"", BeanPropertyRowMapper.newInstance(Student.class));
        return list;
    }

    public Student getById(int id) {
        String sql = "Select * From \"Student\" Where \"id\" = :searchedId";
        Map<String, Integer> param = new HashMap<>();
        param.put("searchedId", id);

        return jdbcTemplate.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(Student.class));
    }

    public boolean save(Student student) {
        String sql = "Insert Into \"Student\"(\"name\", \"teacher_id\", \"language_id\") Values(:name, :teacher_id, :language_id)";
        Map<String, Object> param = new HashMap<>();
        param.put("name", student.getName());
        param.put("teacher_id", student.getTeacher_id());
        param.put("language_id", student.getLanguage_id());

        return jdbcTemplate.update(sql, param) == 1;
    }

    public boolean deleteById(int id) {
        String sql = "Delete From \"Student\" Where \"id\" = :id";
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);

        return jdbcTemplate.update(sql, param) == 1;
    }
}
