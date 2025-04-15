package org.example.sec03.assigent03.client;

import org.example.common.AbstractHttpClient;
import reactor.core.publisher.Flux;

public class ExternalServicesClient extends AbstractHttpClient {

    public Flux<Integer> getStocks() {
        return this.httpClient.get()
                .uri("/demo02/stock/stream" )
                //Obtiene el cuerpo de la respuesta HTTP como un flujo de bytes
                .responseContent()
                //Convierte el flujo de bytes a una cadena
                .asString()
                .map(Integer::parseInt);
    }
}
