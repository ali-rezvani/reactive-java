package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
        /*Flux.create(fluxSink -> {
                    fluxSink.next(1);
                    fluxSink.next(2);
                    fluxSink.next(3);
                    fluxSink.complete();
                })
                .subscribe(Util.subscriber());*/

        Flux.create(fluxSink -> {
                    String country;
                    do {
                        Util.sleep(1);
                        country = Util.faker().country().name();
                        fluxSink.next(country);
                    } while (!country.toLowerCase().equals("canada"));
                    fluxSink.complete();
                })
                .subscribe(Util.subscriber());

    }
}
