package org.example.sec09;

import org.example.applications.OrderService;
import org.example.applications.UserService;
import org.example.common.Util;

public class Lec08MonoFlatMapMany {


    public static void main(String[] args) {


        UserService.getUserId("user1")
                .flatMapMany(OrderService::getUserOrders)
                .subscribe(Util.subscriber());


        Util.sleepSeconds(30);

    }
}
