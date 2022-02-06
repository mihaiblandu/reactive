package com.learnreactiveprogramming.util;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataSet {
    public static List<String> namesList(){

        Faker faker = new Faker();

        return IntStream.range(0,100)
                .mapToObj(el->faker.name()
                        .fullName())
                .collect(Collectors.toList());
    }
}