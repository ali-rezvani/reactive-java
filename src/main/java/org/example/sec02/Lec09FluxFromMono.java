package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("A");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Util.doOnNext());
    }

    private static void doAction(Flux<String> flux){

    }
}
