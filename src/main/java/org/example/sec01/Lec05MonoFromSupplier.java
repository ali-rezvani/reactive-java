package org.example.sec01;

import org.example.common.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        Supplier<String> supplier= Lec05MonoFromSupplier::getName;
        Mono<String> mono=Mono.fromSupplier(supplier);

        mono.subscribe(Util.doOnNext(),
                Util.doOnError(),
                Util.donOnComplete());

        Callable<String> callable= Lec05MonoFromSupplier::getName;
        Mono.fromCallable(callable)
                .subscribe(Util.doOnNext());
    }

    private static String getName(){
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }
}
