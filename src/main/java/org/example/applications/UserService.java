package org.example.applications;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public class UserService {

    public static final Map<String, Integer> userTable = Map.of("user1", 1, "user2", 2, "user3", 3);

    public static Flux<User> getUsers() {
        return Flux.fromIterable(userTable.entrySet()).map(entry -> new User(entry.getValue(), entry.getKey()));
    }

    public static Mono<Integer> getUserId(String username) {
        return Mono.fromSupplier(() -> (userTable.get(username)));
    } // <1>
}
