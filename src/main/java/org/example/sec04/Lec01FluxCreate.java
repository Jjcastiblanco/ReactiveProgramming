package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

    /*

    +Debes usar Flux.create para consumir una API REST que devuelve datos como nombres?
    👉   No necesariamente.
        Si tu API te responde de forma directa (por ejemplo, una lista de nombres en JSON), entonces no necesitas Flux.create, porque estás trabajando con una fuente pull y
        finita, que ya es naturalmente compatible con programación reactiva.

     ¿Cuándo sí podrías usar Flux.create con una API?
        Usa Flux.create solo si:
        
        La API es no reactiva y basada en callbacks o listeners.
        Ejemplo: una SDK antigua que usa un onResponse() o eventos push.

        Quieres manejar múltiples respuestas en tiempo real, como un stream tipo SSE o WebSocket, y no tienes soporte directo.

        Necesitas emitir eventos a medida que llegan datos parcialmente, no una lista completa.


     */
    public static void main(String[] args) {

        Flux.create(sink -> {
//            sink.next(1);
//            sink.next(2);
//            sink.next(3);
//            sink.complete();

//            for (int i = 0; i < 10; i++) {
//                sink.next(Util.faker().name().firstName());
//            }
//            sink.complete();
            String country;
            do {
                country = Util.faker().address().country();
                sink.next(country);
            } while (country.equalsIgnoreCase("canada"));
            sink.complete();


        }).subscribe( Util.subscriber()) ;

    }
}
