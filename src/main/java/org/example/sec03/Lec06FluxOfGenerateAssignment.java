package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxOfGenerateAssignment {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(0);
        Flux.generate(synchronousSink -> {
                   String country=Util.faker().country().name();
                    System.out.println("Emitting "+country);
                    synchronousSink.next(country);
                    atomicInteger.incrementAndGet();
                    if (country.toLowerCase().equals("canada")) {
                    synchronousSink.complete();
                    }
                })
//                .take(3)
                .subscribe(Util.subscriber());
    }
}
