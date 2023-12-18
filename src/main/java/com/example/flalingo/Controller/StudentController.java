package com.example.flalingo.Controller;

import com.example.flalingo.Entity.Student;
import com.example.flalingo.Entity.Teacher;
import com.example.flalingo.Repository.StudentRepository;
import com.example.flalingo.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository repository;

    @Autowired
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> list = repository.getAll();
        if (list.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(list);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        Student student = repository.getById(id);
        if (student != null)
            return ResponseEntity.ok(student);
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        boolean result = repository.deleteById(id);
        if (result)
            return ResponseEntity.ok(id + " ID STUDENT HAS REMOVED SUCCESSFULLY");
        else
            return ResponseEntity.badRequest().body(id + " ID STUDENT NOT REMOVED (FAILED)");
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Student student) {
        boolean result = repository.save(student);
        if (result)
            return ResponseEntity.ok("NEW RECORD SAVED");
        else
            return ResponseEntity.badRequest().body(" NEW RECORD NOT SAVED (FAILED)");
    }
}
