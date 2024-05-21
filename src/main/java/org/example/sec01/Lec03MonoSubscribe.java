package org.example.sec01;

import org.example.common.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {
        Mono<Integer> mono=Mono.just("ESTRFFggg")
                .map(String::length);
//                .map(l->l/0);
        /*mono.subscribe(
                System.out::println,
                err->System.out.println(err.getMessage()),
                ()->System.out.println("Done")

        )*/;
        mono.subscribe(Util.doOnNext(),
                Util.doOnError(),
                Util.donOnComplete());

    }
}
