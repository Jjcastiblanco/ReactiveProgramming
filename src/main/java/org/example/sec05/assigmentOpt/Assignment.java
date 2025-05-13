package org.example.sec05.assigmentOpt;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Assignment {

    private static final Logger log = LoggerFactory.getLogger(Assignment.class);




    public static void main(String[] args) {

        ProductServiceImp productService = new ProductServiceImp();

        productService.getProducts(2)
                .map(product -> switch (product.id()) {
                    case 1, 2, 3 -> product.name();
                    default -> "Product not found";
                }).timeout(Duration.ofSeconds(1), Mono.empty())
                .defaultIfEmpty(String.valueOf(new Product(0, "Product not found")))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);

    }

}
