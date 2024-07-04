package org.example.sec05;

import org.example.common.Util;
import org.example.sec05.assignment.IncomeService;
import org.example.sec05.assignment.InventoryService;
import org.example.sec05.assignment.OrderService;

public class Lec06Assignment {
    public static void main(String[] args) {
        var orderService=new OrderService();
        var incomeService=new IncomeService();
        var inventoryService=new InventoryService();
        orderService.orderStream().subscribe(incomeService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService
                .inventoryStream()
                .subscribe(Util.subscriber("Inventory"));
        incomeService
                .incomeStream()
                .subscribe(Util.subscriber("Income"));
        Util.sleep(60);
    }
}
