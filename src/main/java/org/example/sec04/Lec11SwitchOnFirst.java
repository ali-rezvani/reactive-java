package org.example.sec04;

import org.example.common.Util;
import org.example.sec04.helper.Person;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.function.Function;

public class Lec11SwitchOnFirst {
    public static void main(String[] args) {
        getPersons()
                .switchOnFirst((signal, personFlux) -> {
                    System.out.println("inside switch-on-first.");
                    return signal.isOnNext() && Objects.requireNonNull(signal.get()).getAge() > 10
                            ? personFlux
                            : applyFilter().apply(personFlux);
                })
//                .transform(applyFilter())
                .subscribe(Util.subscriber());
    }

    private static Flux<Person> getPersons() {
        return Flux
                .range(1, 10)
                .map(i -> new Person());
    }

    private static Function<Flux<Person>, Flux<Person>> applyFilter() {
        return flux -> flux
                .filter(person -> person.getAge() > 10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not Allowed:" + p));
    }
}
