package org.example.sec06;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {
    public static void main(String[] args) {
        Flux<Object> flux=Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .doOnNext(i->printThreadName("next"+i));
        Runnable runnable=()->flux.subscribe(v->printThreadName("sub "+v));
        for (int i=0;i<2;i++){
            new Thread(runnable).start();
        }
        Util.sleep(5);
    }

    private static void printThreadName(String message) {
        System.out.println(message + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
