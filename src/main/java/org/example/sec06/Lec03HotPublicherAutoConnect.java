package org.example.sec06;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;



public class Lec03HotPublicherAutoConnect {

    public static final Logger log = LoggerFactory.getLogger(Lec02HotPublisher.class);

    public static void main(String[] args) {

        /*
         not stop the stream
         make is real hot pusblish().autoConnect(0)


         */
        var movieStream = movieStream().replay().autoConnect(0);
        Util.sleepSeconds(2);

        movieStream.take(3).subscribe(Util.subscriber("A"));

        Util.sleepSeconds(5);

        movieStream.subscribe(Util.subscriber("B"));

        Util.sleepSeconds(15);

    }

    private static Flux<String> movieStream() {
        return Flux.generate(() -> {
                            log.info("Reading movie stream");
                            return 1;
                        }, (state, sink) -> {
                            var scene = "Scene " + state;
                            log.info("reading scene: {}", scene);
                            sink.next(scene);
                            return ++state;
                        }
                )
                .take(10)
                .delayElements(Duration.ofSeconds(1))
                .cast(String.class);
    }
}
