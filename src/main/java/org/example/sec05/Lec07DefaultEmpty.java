package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec07DefaultEmpty {

    public static void main(String[] args) {

        Flux.range(1,10)
                .filter(i -> i > 5)
                .defaultIfEmpty(50)
                .subscribe(Util.subscriber());
    }
}
