package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        Util.sleep(1);
                        country = Util.faker().country().name();
                        System.out.println("Emitting: "+country);
                        Util.sleep(1);
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("canada")&&!fluxSink.isCancelled());
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
