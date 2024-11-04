package com.example.springbootreactive.controller;

import com.example.springbootreactive.entity.Person;
import com.example.springbootreactive.repository.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Validated
@RestController
public class PersonRestController {
    private final PersonRepository personRepository;

    public PersonRestController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Saving a person.
     */
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<Person> savePerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
