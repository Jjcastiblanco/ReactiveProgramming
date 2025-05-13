package org.example.sec06;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Lec02HotPublisher {

    public static final Logger log = LoggerFactory.getLogger(Lec02HotPublisher.class);

    public static void main(String[] args) {

        /*
        Share convert into a hot publisher

        The share() operator converts a cold publisher into a hot publisher,
        var movieStream = movieStream().share(); // this is a cold publisher

        hot -> 1 data producer all subscribers share the same data

        share = publish().refCount(1);
        it  needs one subscriber to start the stream
        it stops the stream when there are no more subscribers

         */
        var movieStream = movieStream().share();
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
