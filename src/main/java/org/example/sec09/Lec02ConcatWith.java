package org.example.sec09;

import org.example.common.Util;
import reactor.core.publisher.Flux;

public class Lec02ConcatWith {



    public static void main(String[] args) {

        fallback2();

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
}
