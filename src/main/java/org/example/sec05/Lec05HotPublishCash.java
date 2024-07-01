package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec05HotPublishCash {
    public static void main(String[] args) {
//        cache=publish + replay
        Flux<String> movieFlux=Flux
                .fromStream(Lec05HotPublishCash::getMovie)
                .delayElements(Duration.ofSeconds(2))
                .cache();
        Util.sleep(3);
        movieFlux
                .subscribe(Util.subscriber("S1"));
        Util.sleep(10);
        movieFlux
                .subscribe(Util.subscriber("S2"));
        Util.sleep(60);
    }

    private static Stream<String> getMovie(){
        return Stream.of("Scene-1" ,
                "Scene-2",
                "Scene-3",
                "Scene-4",
                "Scene-5",
                "Scene-6",
                "Scene-7",
                "Scene-8"
        );
    }
}
