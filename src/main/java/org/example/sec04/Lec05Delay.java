package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05Delay {
    public static void main(String[] args) {
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());
    }
}
