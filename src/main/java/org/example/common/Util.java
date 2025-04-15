package org.example.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

import java.time.Duration;

/*
* @author Firstname Lastname
* @version 1.0
* @since 1.0
* @class Util
* @This class is used to create subscribers
* */
public class Util {

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
}
