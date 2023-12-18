package com.example.flalingo.Controller;

import com.example.flalingo.Entity.Language;
import com.example.flalingo.Entity.Teacher;
import com.example.flalingo.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherRepository repository;

    @Autowired
    public TeacherController(TeacherRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> getAll() {
        List<Teacher> list = repository.getAll();
        if (list.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(list);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Teacher> getById(@PathVariable int id) {
        Teacher teacher = repository.getById(id);
        if (teacher != null)
            return ResponseEntity.ok(teacher);
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        boolean result = repository.deleteById(id);
        if (result)
            return ResponseEntity.ok(id + " ID TEACHER HAS REMOVED SUCCESSFULLY");
        else
            return ResponseEntity.badRequest().body(id + " ID TEACHER NOT REMOVED (FAILED)");
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Teacher teacher) {
        boolean result = repository.save(teacher);
        if (result)
            return ResponseEntity.ok("NEW RECORD SAVED");
        else
            return ResponseEntity.badRequest().body(" NEW RECORD NOT SAVED (FAILED)");
    }
}
