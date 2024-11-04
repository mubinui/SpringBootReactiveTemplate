package com.example.springbootreactive.repository;

import com.example.springbootreactive.entity.Person;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PersonRepository extends R2dbcRepository<Person, Long> {
}
