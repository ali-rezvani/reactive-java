package org.example.sec01;

import org.example.common.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
//        Runnable runnable=()->System.out.println("Operation completed");
        Runnable runnable=timeConsumingProcess();
        Mono.fromRunnable(runnable)
                .subscribe(Util.doOnNext(),
                        Util.doOnError(),
                        Util.donOnComplete());
    }

    private static Runnable timeConsumingProcess(){
        return ()->{
            Util.sleep(3);
            System.out.println("Operation completed");
        };
    }
}
