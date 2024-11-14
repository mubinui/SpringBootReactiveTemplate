package com.example.springbootreactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Function;

@Service
public class FluxService {

    /**
     * All flux test operators goes here .
     */

    public Flux<String> getFlux() {
        return Flux.just("Hello", "World", "Mubin", "Bro").log();
    }

    /**
     * We can send data using just directly.
     * We can also pass the data from iterable too.
     */

    public Flux<String> getFlux2() {
        List<String> names = List.of("A", "B", "C", "D", "E", "F", "G", "H");
        return Flux.fromIterable(names);
    }

    /**
     * We can also create blank iterables .
     */

    public Flux<Void> getFlux3() {
        return Flux.empty();

    }

    /**
     * Let's use the map.
     */

    public Flux<String> mappingfluxData() {

        return getFlux2().map(name -> {
            name = name.toUpperCase();
            System.out.println(name);
            return name;
        });

    }

    /**
     * Let's learn using filter
     */

    public Flux<String> filterFluxData() {

        return getFlux2().filter(name -> name.length() == 1);

    }

    /**
     * Let's work with flatmap.
     * We can create a new flax at the same time .
     */

    public Flux<String> flatMapFluxData() {
        return getFlux2().flatMap(name -> Flux.just(name.toLowerCase()));
    }


    /**
     * Lets checkout transform.
     */
    
    Function<Flux<String>,Flux<String>> funcInterface = (name)->name.map(String::toUpperCase);

    public Flux<String> transformFluxData() {
        return getFlux2().transform(funcInterface).log();
    }


    /**
     * Default value
     */

    public Flux<String> ifExample(int length){

        return getFlux().filter(name->name.length()>length).defaultIfEmpty("Mubin Mubin UIC");
    }

    /**
     * concat(static) / concatWith(instance)
     */

    public Flux<String> concatExample(int length){
        return Flux.concat(getFlux(),getFlux2());
    }



}
