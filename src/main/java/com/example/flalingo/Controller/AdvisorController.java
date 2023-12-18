package com.example.flalingo.Controller;

import com.example.flalingo.Entity.Advisor;
import com.example.flalingo.Entity.Student;
import com.example.flalingo.Repository.AdvisorRepository;
import com.example.flalingo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advisor")
public class AdvisorController {
    private final AdvisorRepository repository;

    @Autowired
    public AdvisorController(AdvisorRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Advisor>> getAll() {
        List<Advisor> list = repository.getAll();
        if (list.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(list);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Advisor> getById(@PathVariable int id) {
        Advisor advisor = repository.getById(id);
        if (advisor != null)
            return ResponseEntity.ok(advisor);
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        boolean result = repository.deleteById(id);
        if (result)
            return ResponseEntity.ok(id + " ID ADVISOR HAS REMOVED SUCCESSFULLY");
        else
            return ResponseEntity.badRequest().body(id + " ID ADVISOR NOT REMOVED (FAILED)");
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Advisor advisor) {
        boolean result = repository.save(advisor);
        if (result)
            return ResponseEntity.ok("NEW RECORD SAVED");
        else
            return ResponseEntity.badRequest().body(" NEW RECORD NOT SAVED (FAILED)");
    }
}
