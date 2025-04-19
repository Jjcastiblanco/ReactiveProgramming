package org.example.sec04;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;


/**
 * Eres responsable de emitir elementos uno por uno
 *
 * Puedes mantener un estado entre emisiones
 *
 * Tienes control explícito sobre cuándo terminar el flujo
 * Para casos donde Flux.interval() no es suficiente:
 * Stateful: Mantiene estado entre emisiones
 *
 * Control preciso: Decides exactamente cuándo emitir y terminar
 *
 * Single-threaded: No requiere sincronización (a diferencia de Flux.create)
 *
 * Backpressure-aware: Respeta naturalmente la demanda del suscriptor

 */
public class Lec06FluxGenerate {

    public static final Logger log = LoggerFactory.getLogger(Lec06FluxGenerate.class);

    public static void main(String[] args) {

        generateTake();
    }

    private static void stateless() {
        Flux.generate(
                () -> 0,                     // Estado inicial: contador en 0
                (state, a) -> {
                    int nextValue = state * 2 + 1;
                    a.next(nextValue);    // Emite 1, 3, 7, 15, 31...
                    if (nextValue > 100) {
                        a.complete();     // Termina el flujo
                    }
                    return nextValue;        // Nuevo estado
                }
        ).subscribe(Util.subscriber());
    }

    private static void generate() {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(1);
            synchronousSink.next(2); // we can emmit only one value at a time
            // synchronousSink.complete();
            // synchronousSink.error(new RuntimeException("Error"));
        }).subscribe(Util.subscriber());
    }

    private static void generateTake() {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(1);
            //synchronousSink.next(2); // we can emmit only one value at a time
            // synchronousSink.complete();
            // synchronousSink.error(new RuntimeException("Error"));
        }).take(2)
        .subscribe(Util.subscriber());
    }
}
