package org.example.sec09.helper;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;


import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static final Logger log = LoggerFactory.getLogger(NameGenerator.class);
    //Simulate redis add cache
    List<String> redis = new ArrayList<>();

    public Flux<String> generateName(){
        return Flux.generate(synchronousSink -> {
            var name = Util.faker().name().firstName();
            log.info("name: {}", name);
            Util.sleepSeconds(1);
            redis.add(name);
            synchronousSink.next(name);

        }).startWith(redis)
                .cast(String.class);
    }
 }
