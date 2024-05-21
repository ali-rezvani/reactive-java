package org.example.sec01;

import org.example.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

    public static void main(String[] args) {
        userRepository(11)
                .subscribe(Util.doOnNext(),
                        Util.doOnError(),
                        Util.donOnComplete());
    }
    private static Mono<String> userRepository(int userId){
        if (userId==1){
            return Mono.just(Util.faker().name().fullName());
        }else if (userId==2){
            return Mono.empty();
        }else {
            return Mono.error(new RuntimeException("Error: Not in allowed range"));
        }
    }
}
