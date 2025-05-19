package org.example.sec09;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Lec12Then {


    /*
     * ThenSecuenciar tareas:

        Ejecutar una acción después de que otra termine, sin usar su resultado.

        Ejemplo: Enviar un correo después de guardar un registro.

        Limpiar recursos:

        Cerrar conexiones o archivos al finalizar un proceso.

        Encadenar flujos:

        Iniciar un nuevo flujo cuando otro termine.
     */

    public static final Logger log = LoggerFactory.getLogger(Lec12Then.class);

    public static void main(String[] args) {

        saveRecord(List.of("A", "B", "C"))
                .then(sendNotification(List.of("A", "B", "C")))
                .subscribe(Util.subscriber());


        Util.sleepSeconds(10);


    }

    public static Flux<String> saveRecord(List<String> list) {
        return Flux.fromIterable(list)
                .map(r -> "Saved " + r)
                .delayElements(Duration.ofMillis(100));

    }

    public static Mono<Void> sendNotification(List<String> list) {
        return Mono.fromRunnable(() -> log.info("Sending notification"));
    }
}
