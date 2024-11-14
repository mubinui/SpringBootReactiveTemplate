package com.example.springbootreactive;

import com.example.springbootreactive.service.FluxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class SpringbootFluxTest {

    @Autowired
    private FluxService fluxService;

    @Test
    void testing() {
        this.fluxService.getFlux().subscribe(data ->
        {
            System.out.println(data);
            System.out.println("Printing with flux");
        });

    }

    @Test
    void testing2() {
        this.fluxService.getFlux2().subscribe(System.out::println);
    }

    @Test
    void testing3() {
        Flux<String> getFlux = this.fluxService.mappingfluxData();
        StepVerifier.create(getFlux).expectNextCount(8).verifyComplete();
    }

    @Test
    void testing4() {
        Flux<String> getFlux = this.fluxService.filterFluxData();
        StepVerifier.create(getFlux).expectNextCount(8).verifyComplete();
    }

    @Test
    void testing5() {
        this.fluxService.flatMapFluxData().subscribe(System.out::println);

    }


    @Test
    void concatExample() {
    }
}
