package org.example.sec09.helper;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Copa {

    public static final Logger log = LoggerFactory.getLogger(Copa.class);

    private static final String AIRLINE = "Copa";

    public static Flux<Fligth> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(4, 8))
                .delayElements(Duration.ofMillis(Util.faker().random().nextInt(20, 80)))
                .map(i -> new Fligth(AIRLINE, Util.faker().random().nextInt(80, 900)))
                .transform(Util.fluxDebugger("Copa"));
    }
}
