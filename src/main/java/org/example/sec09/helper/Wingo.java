package org.example.sec09.helper;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Wingo {

    public static final Logger log = LoggerFactory.getLogger(Wingo.class);

    private static final String AIRLINE = "Wingo";

    public static Flux<Fligth> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(1, 6))
                .delayElements(Duration.ofMillis(Util.faker().random().nextInt(70, 80)))
                .map(i -> new Fligth(AIRLINE, Util.faker().random().nextInt(800, 900)))
                .transform(Util.fluxDebugger("Wingo"));
    }
}
