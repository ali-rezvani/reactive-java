package org.example.sec06;

import org.example.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOnDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printCurrentThread("create");
                    fluxSink.next(1);
                })
                .subscribeOn(Schedulers.newParallel("ali"))
                .doOnNext(i -> printCurrentThread("next" + i));
        Runnable runnable=()->flux
                .doFirst(() -> printCurrentThread("First2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printCurrentThread("First1"))
                .subscribe(v -> printCurrentThread("sub" + v));
        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }
        Util.sleep(5);
    }

    private static void printCurrentThread(String message) {
        System.out.println(message + "\t\tThread: " + Thread.currentThread().getName());
    }
}
