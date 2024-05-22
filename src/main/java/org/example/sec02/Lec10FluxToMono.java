package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec10FluxToMono {
    public static void main(String[] args) {
        Flux.range(1,10)
                .filter(i->i>3)
                .next()
                .subscribe(Util.doOnNext());
    }
}
