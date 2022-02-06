package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService =
            new FluxAndMonoGeneratorService();

    @Test
    void namesFlux() {
        //given

        //when
        var namesFlux = fluxAndMonoGeneratorService.namesFlux();

        //then
        StepVerifier.create(namesFlux)
                .expectNext("alex", "ben","chloe")
                .expectNextCount(0)
                //.expectNext("alex")
                //.expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void namesFlux_map() {
        //given

        //when
        var namesFlux = fluxAndMonoGeneratorService.namesFlux_map();

        //then
        StepVerifier.create(namesFlux)
                .expectNext("ALEX", "BEN", "CHLOE")
                .verifyComplete();
    }

    @Test
    void namesFlux_immutability() {
        //given

        //when
        var namesFlux = fluxAndMonoGeneratorService.namesFlux_immutability();

        //then
        StepVerifier.create(namesFlux)
                .expectNext("alex", "ben","chloe")
                .verifyComplete();
    }

    @Test
    void concat(){
        Flux<String> a = Flux.just("a","c","b");
        Flux<String> b = Flux.just("a","b","c");
        var c =  b.concatWith(a);
        //c.log().subscribe();
        StepVerifier.create(c)
                .expectNext("a")
                .expectNextCount(5)
                .verifyComplete();
        c.log().subscribe();
    }
}
