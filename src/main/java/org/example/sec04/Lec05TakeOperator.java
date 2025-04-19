package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

public class Lec05TakeOperator {
    /*
    * El operador take() limita el flujo de datos a un determinado número de elementos.

    * Take is similar to java.util.stream().limit()
    * */
    public static void main(String[] args) {

            takeUntil();


    }

    private static void intStream() {
        IntStream.rangeClosed(1,10)
                .limit(9)
                .forEach(System.out::println);
    }

    private static void take() {
        Flux.range(1,10)
                .log("take")
                .take(2)
                .log("subscribe")
                .subscribe(Util.subscriber());
    }

    private static void takeWhile() {
        Flux.range(1,10)
                .log("take")
                .takeWhile(i -> i < 5)
                .log("subscribe")
                .subscribe(Util.subscriber());
    }

    private static void takeUntil() {
        Flux.range(1,10)
                .log("take")
                .takeUntil(i -> i < 5) // stop when the value is greater than 5
                .log("subscribe")
                .subscribe(Util.subscriber());
    }
}
