package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec08GenerateWithState {

    public static void main(String[] args) {
        generateWithState();
    }

    private static void generateWithState() {
        Flux.generate(
                () -> 0,                     // Estado inicial: contador en 0
                (state, asyncSink) -> {
                    var country = Util.faker().address().country();
                    asyncSink.next(country);
                    state++;
                    if (state == 10 || country.equals("Colombia")) {
                        asyncSink.complete();
                    }
                    return state;        // Nuevo estado
                }).subscribe(Util.subscriber());
    }

    private static void generateNotClean() {
        AtomicInteger counter = new AtomicInteger(0);
        Flux.generate(synchronousSink -> {
            var country = Util.faker().address().country();
            synchronousSink.next(country);
            counter.incrementAndGet();
            if (counter.get() == 10 || country.equals("Colombia")) {
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());
    }
}
