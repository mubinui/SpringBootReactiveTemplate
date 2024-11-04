package com.example.springbootreactive.service;

import com.example.springbootreactive.entity.Person;
import com.example.springbootreactive.repository.PersonRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {
    private final PersonRepository personRepository;


    public StudentServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     *find person by Id.
     */

    Mono<Person> findById(Long id) {
        return personRepository.findById(id);

    }

    /**
     *Saving in database.
     */

    Mono<Person> save(Person person) {
        return personRepository.save(person);
    }
}
