package org.example.sec01;

import org.example.common.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(getName(1))
                .subscribe(Util.doOnNext());
        Util.sleep(1);
    }

    private static CompletableFuture<String> getName(int callNumber){
        System.out.println("entered getName method.."+callNumber);
        return CompletableFuture.supplyAsync(()->Util.faker().name().fullName());
    }
}
