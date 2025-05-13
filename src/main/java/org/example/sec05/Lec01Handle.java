package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

/*
* handle te da control total sobre cada emisión.
* Es un operador súper poderoso porque puedes hacer
* varias cosas al mismo tiempo que normalmente tendrías
* que hacer con varios operadores (map, filter, onError).

*
 */
public class Lec01Handle {

    public static void main(String[] args) {

        Flux.range(1,10)
                .filter(i -> i != 7)
                .handle((i, sink) -> {
                   switch (i) {
                       case 1 -> sink.next(-2);
                       case 4 -> {}
                       case 7 -> sink.error(new RuntimeException("Error"));
                       default -> sink.next(i);
                   }
                })
                .subscribe(Util.subscriber());

    }
}
