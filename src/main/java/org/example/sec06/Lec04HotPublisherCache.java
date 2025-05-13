package org.example.sec06;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;


/*
 * make is real hot pusblish().autoConnect(0)
 * replay allow us cache the data
 *     .publish().refCount(2); Inicia la emisión cuando hay al menos 2 suscriptores activos. Detiene la emisión si el número de suscriptores cae por debajo de 2.

 */
public class Lec04HotPublisherCache {

    private static final Logger log = LoggerFactory.getLogger(Lec04HotPublisherCache.class);
    public static void main(String[] args) {

        var stockFlux = stockStream().replay().autoConnect(0);
        Util.sleepSeconds(2);

        log.info("stockFlux A: {}", stockFlux);

        stockFlux.subscribe(Util.subscriber("A"));

        Util.sleepSeconds(5);

        log.info("stockFlux B: {}", stockFlux);

        stockFlux.subscribe(Util.subscriber("B"));

        Util.sleepSeconds(15);

    }

    private static Flux<Integer> stockStream() {
        return Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().random().nextInt(1, 100)))
                .delayElements(Duration.ofSeconds(3))
                .doOnNext(i -> log.info("emitting value: {}", i))
                .cast(Integer.class);
    }
}
