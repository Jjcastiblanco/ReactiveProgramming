package org.example.sec09;

import org.example.applications.PaymentService;
import org.example.applications.UserService;
import org.example.common.Util;

public class Lec07MonoFlatMap {



    public static void main(String[] args) {


        UserService.getUserId("user1")
                .flatMap(PaymentService::getBalance)
                .subscribe(Util.subscriber());

    }
}
