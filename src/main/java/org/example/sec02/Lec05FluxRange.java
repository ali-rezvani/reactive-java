package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static void main(String[] args) {
        Flux.range(3,6)
                .subscribe(Util.doOnNext());

        Flux.range(3,7)
                .map(i->Util.faker().name().fullName())
                .subscribe(Util.doOnNext());
        Flux.range(3,5)
                .log()
                .map(i->Util.faker().name().fullName())
                .log()
                .subscribe(Util.doOnNext());
    }
}
