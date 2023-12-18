package com.example.flalingo.Controller;

import com.example.flalingo.Entity.Language;
import com.example.flalingo.Repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    private final LanguageRepository repository;

    @Autowired
    public LanguageController(LanguageRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Language>> getAll() {
        List<Language> list = repository.getAll();
        if (list.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(list);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Language> getById(@PathVariable int id) {
        Language language = repository.getById(id);
        if (language != null)
            return ResponseEntity.ok(language);
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        boolean result = repository.deleteById(id);
        if (result)
            return ResponseEntity.ok(id + " ID RECORD HAS REMOVED SUCCESSFULLY");
        else
            return ResponseEntity.badRequest().body(id + " ID RECORD NOT REMOVED (FAILED)");
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Language language) {
        boolean result = repository.save(language);
        if (result)
            return ResponseEntity.ok("NEW RECORD SAVED");
        else
            return ResponseEntity.badRequest().body(" NEW RECORD NOT SAVED (FAILED)");
    }
}
