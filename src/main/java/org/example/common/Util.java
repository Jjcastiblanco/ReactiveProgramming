package org.example.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.UnaryOperator;

/*
* @author Firstname Lastname
* @version 1.0
* @since 1.0
* @class Util
* @This class is used to create subscribers
* */
public class Util {

    public static final Logger log = LoggerFactory.getLogger(Util.class);

    private static final Faker faker = Faker.instance();


    public static <T> Subscriber <T> subscriber(){
        return new DefaultSubscriberImp<>("");
    }

    public static <T> Subscriber <T> subscriber(String name){
        return new DefaultSubscriberImp<>(name);
    }


    public static Faker faker(){
        return  faker;
    }

    public static void sleepSeconds(int seconds){
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> UnaryOperator<Flux<T>> fluxDebugger(String name) {

        return flux -> flux.doOnSubscribe(s -> log.info("Subscribed to flux {}", name))
                .doOnCancel(() -> log.info("Flux {} cancelled", name))
                .doOnComplete(() -> log.info("Flux {} completed", name));//UnaryOperator
    }
}
