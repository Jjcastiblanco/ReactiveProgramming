package org.example.sec02.client;

import org.example.common.AbstractHttpClient;
import reactor.core.publisher.Mono;

public class ExternalServicesClient extends AbstractHttpClient {

    public Mono<String> getProductName(int productId) {
        return this.httpClient.get()
                .uri("/demo01/product/" + productId)
                //Obtiene el cuerpo de la respuesta HTTP como un flujo de bytes
                .responseContent()
                //Convierte el flujo de bytes a una cadena
                .asString()
                //Convierte la cadena en un Mono
                .next();
    }
}
