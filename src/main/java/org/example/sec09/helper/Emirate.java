package org.example.sec09.helper;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Emirate {

    public static final Logger log = LoggerFactory.getLogger(Emirate.class);

    private static final String AIRLINE = "Emirates";

    public static Flux<Fligth> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(2, 10))
                .delayElements(Duration.ofMillis(Util.faker().random().nextInt(20, 100)))
                .map(i -> new Fligth(AIRLINE, Util.faker().random().nextInt(100, 1000)))
                .transform(Util.fluxDebugger("Emmirate"));
    }
}
