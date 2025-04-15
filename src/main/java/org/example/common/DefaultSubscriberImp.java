package org.example.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriberImp<T> implements Subscriber<T> {

    private static final Logger log = LoggerFactory.getLogger(DefaultSubscriberImp.class);

    private final String name;

    public DefaultSubscriberImp(String name) {
        this.name = name;
    }


    @Override
    public void onSubscribe(Subscription subscription) {

        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        log.info("received: {}",item);
    }

    @Override
    public void onError(Throwable throwable) {

        log.error("{} error", this.name, throwable);
    }

    @Override
    public void onComplete() {
    }
}
