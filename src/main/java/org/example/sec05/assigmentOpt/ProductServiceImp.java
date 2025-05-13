package org.example.sec05.assigmentOpt;

import org.example.common.Util;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ProductServiceImp implements ProductService{
    @Override
    public Mono<Product> getProducts(int id) {
        return Mono.fromSupplier(() -> new Product(id, Util.faker().commerce().productName()))
                .delayElement(Duration.ofSeconds(2));
    }
}
