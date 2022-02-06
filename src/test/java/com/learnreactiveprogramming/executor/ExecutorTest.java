package com.learnreactiveprogramming.executor;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorTest {

    Faker faker = new Faker();

    @Test
    public void mainTest(){

        var temp = LocalTime.now();
        Flux.range(1, 20)
                .parallel(10)
                .runOn(Schedulers.parallel())
                .map(i -> i + 1)
                .map(i -> i * 2)
                .map(i -> i + 1)
                .doOnComplete(()->{
                    System.out.println("========================================");
                })
                .subscribe(System.out::println);

        System.out.println(">>>>>>>>>>>>>>>");
    }

}
