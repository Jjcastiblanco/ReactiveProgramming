package org.example.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.stream.Stream;

public class Lec01LazyStream {

    private static final Logger log = LoggerFactory.getLogger(Lec01LazyStream.class);

    public static void main(String[] args) {


        Stream.of(1)
                //peek no se ejecutara hasta que se ejecute el terminal o su operador
                .peek(i-> log.info("received {}",i))
                //toList es el operador el cual ara que se muestre el stream
                .toList();

    }
}
