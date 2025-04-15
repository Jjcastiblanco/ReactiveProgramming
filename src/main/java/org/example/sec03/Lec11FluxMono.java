package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec11FluxMono {


    /*
    * Convert Flux to Mono
     */
    public static void main(String[] args) {

        var flux = Flux.just("A","B","C");
        var mono = Mono.from(flux);
        mono.subscribe(Util.subscriber());

    }

    private static void monoToFlux() {
        var mono = getUserName(1);
        save(Flux.from(mono));
    }

    private static Mono<String> getUserName(int id) {
        return switch (id) {
            case 1 -> Mono.just("John");
            case 2 -> Mono.empty(); // is similar to Mono.just(null)
            default -> Mono.error(new RuntimeException("User not found"));
        };
    }

    private static void save (Flux<String> flux) {
        flux.subscribe(Util.subscriber());
    }
}
