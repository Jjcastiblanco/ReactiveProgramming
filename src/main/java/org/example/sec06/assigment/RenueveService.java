package org.example.sec06.assigment;


import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class RenueveService implements OrderProcesor {


    private final Map<String, Integer> db = new HashMap<>();



    @Override
    public void consume(Order order) {
        var currentRenueve = db.getOrDefault(order.category(), 0);
        var updatedRenueve = currentRenueve + order.price();
        db.put(order.category(), updatedRenueve);
    }

    @Override
    public Flux<String> stream() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> db.toString());
    }
}
