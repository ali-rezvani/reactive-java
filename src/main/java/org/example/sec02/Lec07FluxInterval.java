package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.doOnNext());
        Util.sleep(10);
    }
}
