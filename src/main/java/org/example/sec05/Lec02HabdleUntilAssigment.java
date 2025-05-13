package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec02HabdleUntilAssigment {

    public static void main(String[] args) {
        assignment();
    }

    private static void assignment() {
        Flux.generate(synchronousSink -> {
                    var country = Util.faker().address().country();
                    synchronousSink.next(country);
                }).handle((country, sink) -> {
                    sink.next(country);
                    if (country.equals("Colombia")) {
                        sink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }




    private static void generateUntil() {
        Flux.<String>generate(synchronousSink -> {
                    var country = Util.faker().address().country();
                    synchronousSink.next(country);
                })
                .takeUntil(country -> country.equals("Colombia"))
                .subscribe(Util.subscriber());
    }
}
