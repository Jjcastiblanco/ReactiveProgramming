package org.example.applications;

import reactor.core.publisher.Mono;

import java.util.Map;

public class PaymentService {

    public static final Map<Integer, Integer> userBalanceTable = Map.of(1, 100, 2, 200, 3, 300);

    public static Mono<Integer> getBalance(int userId) {
        return Mono.fromSupplier(() -> userBalanceTable.get(userId));
    }
}
