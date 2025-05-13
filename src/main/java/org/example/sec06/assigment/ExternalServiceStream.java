package org.example.sec06.assigment;

import org.example.common.AbstractHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.Objects;


public class ExternalServiceStream extends AbstractHttpClient {


    public static final Logger log = LoggerFactory.getLogger(ExternalServiceStream.class);

    private Flux<Order> ordersFlux;

    public Flux<Order> orderStream() {
        if (Objects.isNull(ordersFlux)) {
            this.ordersFlux = this.getOrder();
        }
        return this.ordersFlux;
    }

    private Flux<Order> getOrder() {
        var defaultPath = "/demo04/orders/stream";
        return this.httpClient.get()
                .uri(defaultPath)
                .responseContent()
                .asString()
                .map(this::parseOrder)
                .doOnNext(System.out::println)
                .publish()
                .refCount(2);
    }


    private  Order parseOrder(String response) {
        var parts = response.split(":");

        return new Order(
                parts[1],
                Integer.parseInt(parts[2]),
                Integer.parseInt(parts[3] )
        );
    }
}
