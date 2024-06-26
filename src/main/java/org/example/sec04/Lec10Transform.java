package org.example.sec04;

import org.example.common.Util;
import org.example.sec04.helper.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec10Transform {
    public static void main(String[] args) {
        getPerson()
                .transform(applyFilterMap())
                .subscribe(Util.subscriber());
    }

    private static Flux<Person> getPerson(){
        return Flux.range(1,10)
                .map(i->new Person());
    }
    private static Function<Flux<Person>,Flux<Person>> applyFilterMap(){
        return flux->flux
                .filter(p->p.getAge()>10)
                .doOnNext(p->p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class,person -> System.out.println("Not Allowing.."+person))
                ;
    }
}
