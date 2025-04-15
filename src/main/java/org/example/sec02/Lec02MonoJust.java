package org.example.sec02;

import org.example.sec01.subscriber.SubscriberImp;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {

        var mono = Mono.just("hello");
        var subscriber = new SubscriberImp();
        mono.subscribe(subscriber);

        subscriber.getSubscription().request(1);

    }
}
