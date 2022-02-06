package com.learnreactiveprogramming.merge;

import com.learnreactiveprogramming.service.FluxAndMonoGeneratorService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.IntStream;

public class MergeTests {
    FluxAndMonoGeneratorService fluxAndMonoGeneratorService =
            new FluxAndMonoGeneratorService();

    @Test
    void namesFlux() {
       var ABCFlux = Flux.just( "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
               .delayElements(Duration.ofMillis(100));
       var abcFlux = Flux.just( "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
                .delayElements(Duration.ofMillis(100));


        var flux =abcFlux.mergeWith(ABCFlux);

        IntStream.range(1,100).forEach(
                el->{
                    var temp = LocalTime.now();

                    StepVerifier.create(flux)
                            .expectNextCount(52)
                            .verifyComplete();
                    System.out.println(LocalTime.now().getSecond() - temp.getSecond());
                }
        );


    }
    @Test
    void zipWithFlux() {
        var ABCFlux = Flux.just( "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
                .delayElements(Duration.ofMillis(100));
        var abcFlux = Flux.just( "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
                .delayElements(Duration.ofMillis(100));

        var flux =abcFlux.zipWith(ABCFlux);
                    StepVerifier.create(flux)
                            .expectNextCount(26)
                            .verifyComplete();

    }
    @Test
    void zipFlux() {
        var ABCFlux = Flux.just( "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
                .delayElements(Duration.ofMillis(100));
        var abcFlux = Flux.just( "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
                .delayElements(Duration.ofMillis(100));

        var flux = Flux.zip(abcFlux,ABCFlux);
        StepVerifier.create(flux)
                .expectNextCount(26)
                .verifyComplete();

    }
}
