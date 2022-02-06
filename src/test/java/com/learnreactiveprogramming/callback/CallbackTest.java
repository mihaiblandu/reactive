package com.learnreactiveprogramming.callback;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CallbackTest {

    @Test
    public void mainTest(){
        Faker faker = new Faker();

        AtomicInteger i = new AtomicInteger();
        var flux =Flux.fromIterable(IntStream.range(0,2).mapToObj(el->faker.name().fullName()).collect(Collectors.toList()))
                .map(el-> i.getAndIncrement() +"-" + el)
                .doOnError((e)-> System.out.println("Error " + e.getLocalizedMessage()))
                .doOnNext(String::toUpperCase)
                .doOnSubscribe(s-> System.out.println("Sub " + s))
                .doOnComplete(()-> System.out.println("Completed"))
                .doFinally(signalType -> System.out.println("Finally!!"));

        flux.subscribe(s -> System.out.println(s));

        var newFlux = flux.mergeWith(Flux.error(new RuntimeException("King of Gondor")));
        newFlux
                .doOnError(el-> System.out.println(el.getMessage()))
                .subscribe(s-> System.out.println(s.toUpperCase(Locale.ROOT)));
        System.out.println("Error handled");
    }
}
