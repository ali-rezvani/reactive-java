package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(() -> 1,
                        (state, sink) -> {
                            String county = Util.faker().country().name();
                            sink.next(county);
                            if (state >= 10 || county.equalsIgnoreCase("canada")) {
                                sink.complete();
                            }
                            return state + 1;
                        }
                )
                .take(4)
                .subscribe(Util.subscriber());
    }

}
