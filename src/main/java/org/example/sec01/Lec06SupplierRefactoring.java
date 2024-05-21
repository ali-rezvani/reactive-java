package org.example.sec01;

import org.example.common.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {
        getName(1);
        /*getName(2)
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.doOnNext());*/
        String name=getName(2)
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);
        getName(3);

        Util.sleep(4);
    }

    private static Mono<String> getName(int callNumber){
        System.out.println("entered getName method.."+callNumber);

        return Mono.fromSupplier(()->{
            System.out.println("Generating name.."+callNumber);
            Util.sleep(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
