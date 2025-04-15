package org.example.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscriber {

    private static final Logger log = LoggerFactory.getLogger(Lec03MonoSubscriber.class);
    public static void main(String[] args) {

        var mono = Mono.just(1).map(i->i/2);

        //subscriber tiene opcionalmente implementar los 4 metodos, si quiero
        // darle manejo a los errores, interromper la ejecucion, etc, si queremos manejar
        // el onComplete o el onSubscribe es necesario implementarlos todos
        mono.subscribe(
                i -> log.info("received: {}",i),
                error -> log.error("Marino nos cogieron :",error),
                () -> log.info("completed!")
        );


    }
}
