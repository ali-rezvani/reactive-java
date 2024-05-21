package org.example.sec02;

import org.example.common.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {
    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("Received subscription: " + s);
                        atomicReference.set(s);
                    }

                    @Override
                    public void onNext(Integer i) {
                        System.out.println("onNext: " + i);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("onError: " + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete...");
                    }
                });
        Util.sleep(3);
        atomicReference.get().request(4);
        Util.sleep(5);
        atomicReference.get().request(4);
        Util.sleep(5);
        System.out.println("going to cancel");
        atomicReference.get().cancel();
        Util.sleep(3);
        atomicReference.get().request(3);
    }
}
