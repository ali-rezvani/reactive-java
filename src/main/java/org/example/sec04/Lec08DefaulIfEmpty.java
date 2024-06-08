package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec08DefaulIfEmpty {
    public static void main(String[] args) {
        getOrderItems()
                .filter(i->i>10)
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());
    }

    public static Flux<Integer> getOrderItems(){
        return Flux.range(1,10);
    }
}
