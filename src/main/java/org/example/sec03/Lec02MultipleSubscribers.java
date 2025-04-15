package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {
    public static void main(String[] args) {
        var flux = Flux.just(1,2,3,4,5,6,7,8,9,10);

        flux.subscribe(Util.subscriber("A"));
        flux.subscribe(Util.subscriber("B"));
        flux
                .filter(i -> i % 2 == 0)
                .subscribe(Util.subscriber("C"));
    }
}
