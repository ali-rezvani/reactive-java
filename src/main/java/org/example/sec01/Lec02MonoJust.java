package org.example.sec01;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
public class Lec02MonoJust {
    public static void main(String[] args) {
        Mono<String> mono=Mono.just("Hello world");
        System.out.println(mono);

        mono.subscribe(System.out::println);
    }
}
