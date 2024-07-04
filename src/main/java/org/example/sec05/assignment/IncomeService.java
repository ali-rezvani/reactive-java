package org.example.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class IncomeService {
    private Map<String,Double> db=new HashMap<>();

    public IncomeService() {
        this.db.put("Kids",0.0);
        this.db.put("Automotive",0.0);
    }
    public Consumer<PurchaseOrder> subscribeOrderStream(){
        return purchaseOrder -> this.db.computeIfPresent(purchaseOrder.getCategory(),
                (k,v)->v+ purchaseOrder.getPrice());
    }
    public Flux<String> incomeStream(){
        return Flux
                .interval(Duration.ofMillis(2000))
                .map(i->this.db.toString());
    }
}
