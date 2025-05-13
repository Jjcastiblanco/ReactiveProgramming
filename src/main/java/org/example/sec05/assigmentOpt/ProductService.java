package org.example.sec05.assigmentOpt;


import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> getProducts(int id) ;
}
