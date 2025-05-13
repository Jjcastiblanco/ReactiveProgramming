package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;


/*
* Cuando aplicas delayElements(), Reactor ajusta el mecanismo de backpressure para controlar el flujo de datos. Específicamente, solicita
* un elemento a la vez (request(1)) al upstream. Esto se debe a que:

* Controla la demanda: Al solicitar un solo elemento, se asegura de que no se acumulen elementos en memoria mientras se espera que pase el tiempo de retraso.

* Evita la sobrecarga: Si se solicitaran múltiples elementos y se retrasaran todos, podrían acumularse en memoria, lo que
* podría llevar a problemas de rendimiento o incluso a errores por desbordamiento.

* Este comportamiento es parte del diseño de Reactor para manejar eficientemente el backpressure y garantizar que los recursos se utilicen de manera óptima.
*
* */
public class Lec04Delay {

    public static void main(String[] args) {
        Flux.range(1,10)
                .log("delay")
                //.delayElements(Duration.ofSeconds(2))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(12);
    }
}
