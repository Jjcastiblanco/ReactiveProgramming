package org.example.sec02;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec08MonoFromFuture {
    /*
    * ¿Qué es Mono.fromFuture?
        Mono.fromFuture es un método que permite convertir un CompletableFuture en un Mono. Un CompletableFuture es una clase en Java que representa una promesa de un resultado futuro, es decir, un valor que se calculará de manera asíncrona en algún momento.

        Al convertir un CompletableFuture en un Mono, puedes integrar fácilmente código asíncrono basado en CompletableFuture en un flujo reactivo.

        ¿Cómo funciona?
        Cuando llamas a Mono.fromFuture, el Mono esperará a que el CompletableFuture se complete. Una vez que el CompletableFuture se completa:

        Si el CompletableFuture se completa con un valor, el Mono emitirá ese valor.

        Si el CompletableFuture se completa con una excepción, el Mono emitirá un error.

        Si el CompletableFuture se cancela, el Mono se completará sin emitir ningún valor.
    *
    *
    * */

    private static final Logger log = LoggerFactory.getLogger(Lec08MonoFromFuture.class);

    public static void main(String[] args) {

        //this the problem, is not lezy and ejecutes the methos
//        Mono.fromFuture(getName());
//                .subscribe(Util.subscriber("A"));

        Mono.fromFuture(()-> getName())
                .subscribe(Util.subscriber("A"));


        // this will block the main thread because the future is not completed
        Util.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Getting name ");
            return Util.faker().name().firstName();
        });
    }



}
