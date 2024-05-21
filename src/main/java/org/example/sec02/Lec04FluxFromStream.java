package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {
        List<String> list= List.of("A","b","h","G","N");
        Stream<String> stream= list.stream();

//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);
//        Flux<String> flux=Flux.fromStream(stream);
        Flux<String> flux=Flux.fromStream(()->list.stream());
        flux.subscribe(Util.doOnNext(),Util.doOnError(),Util.donOnComplete());
        flux.subscribe(Util.doOnNext(),Util.doOnError(),Util.donOnComplete());
    }
}
