package com.example.springbootreactive.repository;

import com.example.springbootreactive.entity.Person;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository extends R2dbcRepository<Person, Long> {
    /**
     *  Query Methods
     *  Find Methods
     */

    Mono<Person>findByName(String name);

    Flux<Person>findByAddress(String address);

    Flux<Person>findByNameAndAddress(String name, String address);

    /**
     * the name will come from string name
     */
    @Query("SELECT * FROM person WHERE name=:name")
    Flux<Person> getAllPersonsByName(String name);


}
