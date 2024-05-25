package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    System.out.println("Emitting");
                    synchronousSink.next(Util.faker().country().name());
//                    synchronousSink.complete();
                })
//                .take(3)
                .subscribe(Util.subscriber());
    }
}
