package org.example.sec06.assigment;

import reactor.core.publisher.Flux;

public interface OrderProcesor {

    void consume(Order order);

    Flux<String> stream();
}
