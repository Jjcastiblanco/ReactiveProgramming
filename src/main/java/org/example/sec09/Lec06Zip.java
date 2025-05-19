package org.example.sec09;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec06Zip {


    public static void main(String[] args) {

        record Car(String body, String engine, String tires) {}

        Flux.zip(getBody(), getEngine(), getTires())
                .map(c -> new Car(c.getT1(), c.getT2(), c.getT3()))
                .subscribe(Util.subscriber());


        Util.sleepSeconds(10);
    }

    public static Flux<String> getBody (){
        return Flux.range(1,10)
                .map(i -> "Body " + i)
                .delayElements(Duration.ofMillis(100));
    }
    public static Flux<String> getEngine (){
        return Flux.range(1,10)
                .map(i -> "Engine " + i)
                .delayElements(Duration.ofMillis(100));
    }
    public static Flux<String> getTires (){
        return Flux.error(new RuntimeException("Error"));
    }
}
