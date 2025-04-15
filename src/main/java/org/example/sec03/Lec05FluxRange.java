package org.example.sec03;

import org.example.common.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static void main(String[] args) {

        Flux.range(1,10)
                .subscribe(Util.subscriber());

//        Flux.range(3,5)
//                .map(i -> i/(i-4))
//                .subscribe(Util.subscriber());

//        Flux.range(1,10)
//                .map(i-> Util.faker().name().firstName())
//                .subscribe(Util .subscriber("Valores"));

    }
}
