package org.example.applications;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class OrderService {

    public static final Map<Integer, List<Order>> orderTable = Map.of(
            1, List.of(
                    new Order(1, Util.faker().commerce().productName(), Util.faker().random().nextInt(10, 100)),
                    new Order(2, Util.faker().commerce().productName(), Util.faker().random().nextInt(10, 100)),
                    new Order(3, Util.faker().commerce().productName(), Util.faker().random().nextInt(10, 100))
            ),
            2, List.of(
                    new Order(4, Util.faker().commerce().productName(), Util.faker().random().nextInt(10, 100)),
                    new Order(5, Util.faker().commerce().productName(), Util.faker().random().nextInt(10, 100)),
                    new Order(6, Util.faker().commerce().productName(), Util.faker().random().nextInt(10, 100))
            ),
            3, List.of(
                    new Order(7, Util.faker().commerce().productName(), Util.faker().random().nextInt(10, 100)),
                    new Order(8, Util.faker().commerce().productName(), Util.faker().random().nextInt(10, 100)),
                    new Order(9, Util.faker().commerce().productName(), Util.faker().random().nextInt(10, 100))
            ));

    public static Flux<Order> getUserOrders(Integer userId) {
        return Flux.fromIterable(orderTable.get(userId))
                .delayElements(Duration.ofMillis(500));
    }

}
