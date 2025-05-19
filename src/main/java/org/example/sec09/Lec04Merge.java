package org.example.sec09;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04Merge {

    public static void main(String[] args) {
        demo2();

        Util.sleepSeconds(10);
    }

    public static void demo() {
        Flux.merge(generate(), generate3(), generate2())
                .take(2)
                .subscribe(Util.subscriber());

    }

    public static void demo2(){
        generate()
                .mergeWith(generate2())
                .mergeWith(generate3())
                .take(3)
                .subscribe(Util.subscriber());

    }


    public static Flux<String> generate(){
        return Flux.just("1","2","3")
                .transform(Util.fluxDebugger("A"))
                .delayElements(Duration.ofMillis(10));
    }

    public static Flux<String> generate2(){
        return Flux.just("0","2","3")
                .transform(Util.fluxDebugger("B"))
                .delayElements(Duration.ofMillis(10));
    }

    public static Flux<String> generate3(){
        return Flux.just("0","2","3")
                .transform(Util.fluxDebugger("C"))
                .delayElements(Duration.ofMillis(10));
    }
}
