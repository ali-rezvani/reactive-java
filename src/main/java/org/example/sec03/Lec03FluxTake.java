package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {

    public static void main(String[] args) {
        Flux.range(1,10)
                .log()
                .take(3)
                .log()
                .subscribe(Util.subscriber())
                ;
    }
}
