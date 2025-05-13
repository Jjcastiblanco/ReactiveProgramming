package org.example.sec05;

import org.example.common.Util;
import org.example.sec05.assigment.ExternalSevice;
import reactor.core.publisher.Flux;

public class Lec11Assigment {

    public static void main(String[] args) {


//        var client = new ExternalSevice();
//
//        for (int i = 1; i < 5; i++) {
//            client.getProductName(i)
//                    .subscribe(Util.subscriber());
//        }
//
//        Util.sleepSeconds(3);

//        Flux<Integer> flux = Flux.range(1,10);
//        flux.map(i -> i * 10);
//        flux.subscribe(Util.subscriber());

//        Flux.range(1, 10)
//                .filter(i -> i > 5)
//                .take(2)
//                .next()
//                .subscribe(Util.subscriber());


        Flux.range(1, 3)
                .map(i -> i / (2 - i))
                .onErrorReturn(3)
                .subscribe(Util.subscriber());


    }
}
