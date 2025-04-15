package org.example.sec03;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;


public class Lec04FluxFromStream {

    public static void main(String[] args) {

        var list = List.of(1,2,3,4,5,6,7,8,9,10);

        var flux = Flux.fromStream(list::stream);
        flux.subscribe(Util.subscriber("A"));
        flux.subscribe( Util.subscriber("B"));



    }
}
