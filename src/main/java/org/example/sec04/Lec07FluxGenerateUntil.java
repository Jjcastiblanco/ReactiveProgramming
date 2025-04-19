package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateUntil {

    public static void main(String[] args) {
        generateUntil();
    }

    private static void generate(){
        Flux.generate(synchronousSink -> {
            var country = Util.faker().address().country();
            synchronousSink.next(country);
            if (country.equals("Colombia")) {
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());
    }

    private static void generateUntil(){
        Flux.<String>generate(synchronousSink -> {
            var country = Util.faker().address().country();
            synchronousSink.next(country);
        }).takeUntil(country -> country.equals("Colombia"))
                .subscribe(Util.subscriber());
    }
}
