package com.ld.streams;

import java.util.stream.Stream;

public class StreamBuild {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("Hello", "World");
        stringStream.forEach(System.out::println);

        //fibonacci with streams

        Stream.iterate(new long[]{0,1}, t -> new long[]{t[1], t[0]+t[1]})
                .limit(50)
                .map(t -> t[0])
                .forEach(System.out::println);


        // random numbers

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }
}
