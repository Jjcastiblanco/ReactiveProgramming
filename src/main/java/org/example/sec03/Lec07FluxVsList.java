package org.example.sec03;

import org.example.sec01.subscriber.SubscriberImp;
import org.example.sec03.helper.NameGenerator;

public class Lec07FluxVsList {

    public static void main(String[] args) {

//        var list = NameGenerator.generateNames(10);
//        System.out.println(list);

        var subscriber = new SubscriberImp();

        NameGenerator.getNamesFlux(10)
                .subscribe(subscriber);
        subscriber.getSubscription().request(3);
        subscriber.getSubscription().cancel();

    }
}
