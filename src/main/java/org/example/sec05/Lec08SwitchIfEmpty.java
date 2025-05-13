package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec08SwitchIfEmpty {

    public static void main(String[] args) {
        Flux.range(1,10)
                .filter(i -> i > 11)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100,3);
    }
}
