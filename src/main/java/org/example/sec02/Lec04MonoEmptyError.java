package org.example.sec02;

import org.example.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {
    public static void main(String[] args) {
        getUserName(1)
                .subscribe(Util.subscriber("A"));

        getUserName(2)
                .subscribe(Util.subscriber("B"));

        // this will throw an exception and manage it
        getUserName(3)
                .subscribe(
                        System.out::println,
                        err -> {}
                );

    }

    private static Mono<String> getUserName(int id) {
        return switch (id) {
            case 1 -> Mono.just("John");
            case 2 -> Mono.empty(); // is similar to Mono.just(null)
            default -> Mono.error(new RuntimeException("User not found"));
        };
    }
}
