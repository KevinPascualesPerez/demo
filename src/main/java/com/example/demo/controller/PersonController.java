package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    // GET: listar todas las personas
    @GetMapping
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    // GET: obtener persona por ID
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // POST: crear nueva persona
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    // PUT: actualizar persona existente
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return repository.save(person);
    }

    // DELETE: eliminar persona por ID
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

