package org.example.sec06;

import org.example.common.Util;
import org.example.sec04.helper.NameGenerator;
import reactor.core.publisher.Flux;

public class Lec05FluxCreateIssueFix {

    public static void main(String[] args) {

        var generator = new NameGenerator();
        //Hot
        //var flux = Flux.create(generator).share();
        //Cold
        var flux = Flux.create(generator);
        flux.subscribe(Util.subscriber("A"));
        flux.subscribe(Util.subscriber("B"));

        for (int i = 0; i < 10; i++) {
            generator.generate();
        }

    }
}
