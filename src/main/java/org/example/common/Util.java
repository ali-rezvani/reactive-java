package org.example.common;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.function.Consumer;

public class Util {
    private static final Faker FAKER=Faker.instance(new Locale("fa","Ir"));

    public static Consumer<Object> doOnNext(){
        return System.out::println;
    }

    public static Consumer<Throwable> doOnError(){
        return e->System.out.println(e.getMessage());
    }

    public static Runnable donOnComplete(){
        return ()-> System.out.println("Completed");
    }

    public static Faker faker(){
        return FAKER;
    }

    public static void sleep(int duration) {
        try {
            Thread.sleep(1000*duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
}
