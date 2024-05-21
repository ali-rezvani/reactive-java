package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {

    public static void main(String[] args) {
        List<String> list= Arrays.asList("A","b","h","G","N");
        Flux.fromIterable(list)
                .subscribe(Util.doOnNext());
        String[] array= {"A","b","h","G","N"};
        Flux.fromArray(array)
                .subscribe(Util.doOnNext());

    }
}
