package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec03Callbacks {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    System.out.println("inside create");
                    for (int i = 0; i < 10; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                    System.out.println("completed");
                })
                .doOnComplete(()->System.out.println("doOnComplete"))
                .doFirst(()-> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext:"+o))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe:"+subscription))
                .doFirst(()-> System.out.println("doFirst 2"))
                .doOnRequest(l-> System.out.println("doOnRequest:"+l))
                .doOnError(err-> System.out.println("doOnError:"+err.getMessage()))
                .doOnTerminate(()-> System.out.println("doOnTerminate"))
                .doOnCancel(()-> System.out.println("doOnCancel"))
                .doFinally(signalType -> System.out.println("doFinally: "+signalType))
                .doFirst(()-> System.out.println("doFirst 3"))
                .doOnDiscard(Object.class,o -> System.out.println("doOnDiscard: "+o))
                .subscribe(Util.subscriber());
    }
}
