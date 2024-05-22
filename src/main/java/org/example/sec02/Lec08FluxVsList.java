package org.example.sec02;

import org.example.common.Util;
import org.example.sec02.helper.NameGenerator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec08FluxVsList {
    public static void main(String[] args) {
        List<String> names = NameGenerator.getNames(5);
        System.out.println(names);

        NameGenerator.getFluxNames(5)
                .subscribe(Util.doOnNext());
    }


}
