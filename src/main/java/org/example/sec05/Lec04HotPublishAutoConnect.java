package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec04HotPublishAutoConnect {
    public static void main(String[] args) {
        Flux<String> movieFlux=Flux
                .fromStream(Lec04HotPublishAutoConnect::getMovie)
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0);

        Util.sleep(3);
        movieFlux
                .subscribe(Util.subscriber("S1"));
        Util.sleep(10);
        System.out.println("S2 is about to join");
        movieFlux
                .subscribe(Util.subscriber("S2"));
        Util.sleep(60);
    }

    private static Stream<String> getMovie() {
        System.out.println("Get the movie streaming request...");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7",
                "Scene 8",
                "Scene 9",
                "Scene 10",
                "Scene 11",
                "Scene 12",
                "Scene 13",
                "Scene 14",
                "Scene 15",
                "Scene 16",
                "Scene 17",
                "Scene 18",
                "Scene 19",
                "Scene 20"
        );
    }
}
