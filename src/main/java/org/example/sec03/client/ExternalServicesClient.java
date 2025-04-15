package org.example.sec03.client;

import org.example.common.AbstractHttpClient;
import reactor.core.publisher.Flux;

public class ExternalServicesClient extends AbstractHttpClient {

    public Flux<String> getNames() {
        return this.httpClient.get()
                .uri("/demo02/name/stream" )
                //Obtiene el cuerpo de la respuesta HTTP como un flujo de bytes
                .responseContent()
                //Convierte el flujo de bytes a una cadena
                .asString();
    }
}
