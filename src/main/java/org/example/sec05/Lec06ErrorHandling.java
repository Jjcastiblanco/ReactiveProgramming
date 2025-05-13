package org.example.sec05;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06ErrorHandling {

    public static final Logger log = LoggerFactory.getLogger(Lec06ErrorHandling.class);


    public static void main(String[] args) {

        onErrorContinue();
    }


    // manage errors and continue the stream
    private static void onErrorContinue() {
        Flux.range(1, 10)
                .map(i -> i == 5 ? i / 0 : i)
                .onErrorContinue((err, sink) -> {
                    log.error("error {}", sink, err);
                })
                .subscribe(Util.subscriber());
    }

    private static void errorHandlingFlux() {

        Flux.range(1,10)
                .map(i -> i == 5 ? i / 0 : i)
                .onErrorReturn(IllegalAccessError.class,-0) //Error personalizado de la clase
                .onErrorReturn(ArithmeticException.class,-1)
                //.onErrorReturn(-1) //Error por defecto
                .subscribe(Util.subscriber());
    }

    private static void onErrorComplete() {
        Mono.just(6)
                .onErrorComplete()
                .subscribe(Util.subscriber());
    }

    //Controlando errores de manera personalizada
    private static void errorHandlingMono() {
        Mono.just(6)
                .map(i -> i == 5 ? i / 0 : i)
                .onErrorResume(ArithmeticException.class, ex -> fallback())
                .subscribe(Util.subscriber());
    }

    private static void errorHandlingMonoOne() {
        Mono.error(new RuntimeException("Error"))
                .onErrorResume(ArithmeticException.class, ex -> fallback())
                .onErrorReturn(-1)
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(10,100));
    }
}
