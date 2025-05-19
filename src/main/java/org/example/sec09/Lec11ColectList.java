package org.example.sec09;

import org.example.common.Util;
import reactor.core.publisher.Flux;


/*
        + collectList es tu aliado para transformar un Flux en una lista reactiva (Mono<List<T>>).

    Ideal para operaciones que requieren todos los elementos antes de proceder.

    ¡Evítalo en flujos infinitos o muy grandes! 🚀
 */
public class Lec11ColectList {

    public static void main(String[] args) {

        Flux.range(1,10)
                .collectList()
                .subscribe(Util.subscriber());
    }
}
