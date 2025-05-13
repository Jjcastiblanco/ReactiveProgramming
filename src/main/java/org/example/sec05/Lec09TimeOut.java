package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Mono;

import java.time.Duration;

/*
* timeout
* Controla el tiempo de espera de la emisión de datos

 */
public class Lec09TimeOut {

    public static void main(String[] args) {

//        getProductName()
//                .timeout(Duration.ofSeconds(1))
//                .onErrorReturn("Fallback")
//                .subscribe(Util.subscriber());
//        Util.sleepSeconds(3);

//        getProductName()
//                .timeout(Duration.ofSeconds(1), fallback())
//                .subscribe(Util.subscriber());
//
//        Util.sleepSeconds(3);

        var mono = getProductName()
                .timeout(Duration.ofSeconds(1), fallback());
        mono.timeout(Duration.ofMillis(200))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(3);

    }


    private static Mono<String> getProductName() {

        return Mono.fromSupplier(() -> Util.faker().commerce().productName())
                .delayElement(Duration.ofMillis(1000));

    }

    private static Mono<String> fallback() {
        return Mono.fromSupplier(() -> "Fallback " + Util.faker().commerce().productName())
                .delayElement(Duration.ofMillis(300))
                .doFirst(() -> System.out.println("doFirst"));
    }
}
