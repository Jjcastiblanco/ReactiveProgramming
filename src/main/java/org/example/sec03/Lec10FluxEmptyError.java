package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec10FluxEmptyError {

    public static void main(String[] args) {

        Flux.empty()
                .subscribe(Util.subscriber());

        Flux.error(new RuntimeException("Error"))
                .subscribe(Util.subscriber());
    }
}
