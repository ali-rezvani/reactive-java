package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {
    public static void main(String[] args) {
//        share()=publish().refCount(1)
        Flux<String> movieStream = Flux
                .fromStream(Lec03HotPublish::getMovie)
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(1)
                ;
        movieStream
                .subscribe(Util.subscriber("Ali"));
        Util.sleep(23);
        movieStream
                .subscribe(Util.subscriber("Mohammad"));
        Util.sleep(60);
    }
    //    movie-theatre
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
