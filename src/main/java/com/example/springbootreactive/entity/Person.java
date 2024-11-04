package com.example.springbootreactive.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(name = "person")
public class Person {
    @Id
    Long id;
    String name;
    String email;
    String phone;
}
