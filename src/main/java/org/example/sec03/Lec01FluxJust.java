package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxJust {

    public static void main(String[] args) {

        Flux.just(1,2,3,4,5)
                .subscribe(Util.subscriber());
    }
}
