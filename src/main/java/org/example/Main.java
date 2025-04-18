package org.example;

import org.example.sec01.publisher.PublisherImpl;
import org.example.sec01.subscriber.SubscriberImp;

import java.time.Duration;

/*
    1. publisher does not produce data unless subscriber requests for it
    2. publisher will produce only <= subscriber requested items. publisher can also produce 0 items!
    3. subscriber can cancel the subscription. producer should stop at than moment as subscriber is no longer
    interested in consuming the data
    4. producer can send the error signal
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        demo4();

    }
    private static void demo1(){
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImp();
        publisher.subscribe(subscriber);
    }

    public static void  demo2() throws InterruptedException {

        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImp();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));

    }

    public static void  demo3() throws InterruptedException {

        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImp();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        subscriber.getSubscription().cancel();
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));

    }

    public static void  demo4() throws InterruptedException {

        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImp();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(11);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));

    }
}