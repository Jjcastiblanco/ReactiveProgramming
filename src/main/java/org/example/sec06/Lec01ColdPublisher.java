package org.example.sec06;


import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;


/*
* Cold Publisher genera una secuencia de datos independiente para cada suscriptor.
* Es como un "vídeo bajo demanda": cada suscriptor inicia la reproducción desde el principio y obtiene todos los datos, sin importar cuándo se suscribe.
* Características:
* Inicia una nueva ejecución por cada suscripción.
* Datos completos para cada suscriptor.
* Típico en: Llamadas HTTP, lecturas de archivos, consultas a bases de datos.
*
*
*
* */
public class Lec01ColdPublisher {

    public static final Logger log = LoggerFactory.getLogger(Lec01ColdPublisher.class);

    public static void main(String[] args) {

        var flux = Flux.create(sink -> {
            log.info("invoked");
            for (int i = 0; i < 4; i++) {
                sink.next(i);
            }
            sink.complete();
        });

        flux.subscribe(Util.subscriber("A"));
        flux.subscribe(Util.subscriber("B"));

    }
}
