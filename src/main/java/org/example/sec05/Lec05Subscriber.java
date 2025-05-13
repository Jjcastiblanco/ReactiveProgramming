package org.example.sec05;

import reactor.core.publisher.Flux;

public class Lec05Subscriber {

    public static void main(String[] args) {
        Flux.range(1,10)
                .doOnNext(i -> System.out.println("Subscriber received: " + i))
                .doOnComplete(() -> System.out.println("Subscriber completed!"))
                .doOnError(error -> System.out.println("Subscriber error: " + error.getMessage()))
                .subscribe();
    }
}
