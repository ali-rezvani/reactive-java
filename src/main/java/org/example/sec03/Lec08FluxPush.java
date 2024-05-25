package org.example.sec03;

import org.example.common.Util;
import org.example.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
    public static void main(String[] args) {
        NameProducer producer=new NameProducer();
        Flux.push(producer)
                .subscribe(Util.subscriber());
        Runnable runnable= producer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleep(3);
    }
}
