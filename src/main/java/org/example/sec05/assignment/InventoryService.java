package org.example.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class InventoryService {
    private Map<String,Integer> db=new HashMap<>();

    public InventoryService() {
        this.db.put("Kids",100);
        this.db.put("Automotive",100);
    }
    public Consumer<PurchaseOrder> subscribeOrderStream(){
        return purchaseOrder -> this.db.computeIfPresent(purchaseOrder.getCategory(),
                (k,v)->v- purchaseOrder.getQuantity());
    }
    public Flux<String> inventoryStream(){
        return Flux
                .interval(Duration.ofSeconds(2))
                .map(i->this.db.toString());
    }
}
