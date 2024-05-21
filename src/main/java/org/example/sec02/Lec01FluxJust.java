package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxJust {
    public static void main(String[] args) {
//        Flux<Integer> flux=Flux.just(1,2,3,4,5);
        Flux<Object> flux=Flux.just(1,2,3,4,5,"a",Util.faker().name().fullName());
        /*Flux<Integer> flux=Flux.just("Hi .This is Ali")
                .map(String::length);*/
//                .map(l->l/0);
        flux.subscribe(Util.doOnNext(),
                Util.doOnError(),
                Util.donOnComplete());
    }
}
