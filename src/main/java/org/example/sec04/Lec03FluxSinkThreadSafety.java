package org.example.sec04;

import org.example.common.Util;
import org.example.sec04.helper.NameGenerator;
import org.example.sec04.helper.NameGeneratorOp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;


import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lec03FluxSinkThreadSafety {

    public static final Logger log = LoggerFactory.getLogger(Lec03FluxSinkThreadSafety.class);

    public static void main(String[] args) {
        demo1();
        demo2();
    }

    private static void demo1() {
        var list = new ArrayList<Integer>(); // No thread-safe
        Runnable runnable = () -> {
            for (int i = 0; i < 1000 ; i++) {
                list.add(i);
            }
        };
        for (int i = 0; i < 10 ; i++) {
            Thread.ofPlatform().start(runnable);//múltiples hilos escribiendo sin sincronización
        }
        Util.sleepSeconds(3);
        log.info("list size uno: {}", list.size());
    }

    private static void demo2() {
        var list = new ArrayList<String>();
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(list::add);//Múltiples hilos agregando a la lista
        Runnable runnable = () -> {
            for (int i = 0; i < 1000 ; i++) {
                generator.generate();
            }
        };
        for (int i = 0; i < 10 ; i++) {
            Thread.ofPlatform().start(runnable);
        }
        Util.sleepSeconds(3);
        log.info("list size dos: {}", list.size());
    }

}
