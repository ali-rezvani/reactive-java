package org.example.sec04;

import org.example.common.Util;
import org.example.sec04.helper.OrderService;
import org.example.sec04.helper.UserService;

public class Lec12FlatMap {
    public static void main(String[] args) {
        /*UserService.getUsers()
                .map(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());*/

        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());
        Util.sleep(5);
    }
}
