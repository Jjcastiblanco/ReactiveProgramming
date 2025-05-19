package org.example.sec09;

import org.example.common.Util;
import reactor.core.publisher.Flux;


/*
* Maneja los errores sin bloquear el flujo
 */
public class Lec03ConcatError {

    public static void main(String[] args) {

        Flux.concatDelayError(generate(),generate3(),generate2()).subscribe(Util.subscriber());
    }


    public static void fallback(){
        generate()
                .concatWith(Flux.just("4","5","6"))
                .subscribe(Util.subscriber());
    }

    public static void fallback2(){
        Flux.concat(generate(),generate2()).subscribe(Util.subscriber());
    }



    public static Flux<String> generate(){
        return Flux.just("1","2","3");
    }

    public static Flux<String> generate2(){
        return Flux.just("0","2","3");
    }

    public static Flux<String> generate3(){
        return Flux.error(new RuntimeException("Error"));
    }
}
