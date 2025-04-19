package org.example.sec04;

import org.example.common.Util;
import org.example.sec01.subscriber.SubscriberImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;


/*
*El productor (Flux) genera 10 nombres, pero el consumidor (Subscriber) los pide de 2 en 2.

Si el consumidor no pide más datos, el productor no los envía (evita saturación).

cancel() detiene el flujo cuando ya no se necesitan más datos.


*
 */
public class Lec04FluxCreateDownstreamDemand {

    public static final Logger log = LoggerFactory.getLogger(Lec04FluxCreateDownstreamDemand.class);


    public static void main(String[] args) {

        onDemand();


    }


    private static void  demand(){
        var subscriber = new SubscriberImp();
        Flux.<String>create(fluxSink -> {
                    for (int i = 0; i < 10; i++) {
                        var name = Util.faker().name().firstName();
                        log.info("name: {}", name);
                        fluxSink.next(name);
                    }
                    fluxSink.complete();
                }

        ).subscribe(subscriber);

        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel();
    }

    private static void  onDemand(){
        var subscriber = new SubscriberImp();
        Flux.<String>create(fluxSink -> fluxSink.onRequest(request -> {
            for (int i = 0; i < request; i++) {
                var name = Util.faker().name().firstName();
                log.info("name: {}", name);
                fluxSink.next(name);
            }
        })).subscribe(subscriber);

        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel();


    }

}
