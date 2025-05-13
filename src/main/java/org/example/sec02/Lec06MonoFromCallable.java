package org.example.sec02;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;
/*
* Use FromCallable when you have a method that returns a value
* Manage Exceptions
* Operation is not secure
* Utilice subscriberOn by thread block

 */
public class Lec06MonoFromCallable {

    private static final Logger log = LoggerFactory.getLogger(Lec06MonoFromCallable.class);
    public static void main(String[] args) {

        var list = List.of(1,2,3,4,5);
        //this case subscribe by see the list
//        Mono.just(sum(list)).subscribe(Util.subscriber("A"));
        // this case not subscribe so it will return but invoke the method sum
//        Mono.just(sum(list));
        //this case is better why subscribe when is necessary and not invoke the method
        Mono.fromCallable(() -> sum(list));
        // this case invoke the method sum and subscribe the diference whit
        // fromSupplier is that it will throw an exception and fromCallable acepts exception
        Mono.fromCallable(() -> sum(list))
                .subscribe(Util.subscriber("B"));

    }

    public static int sum(List<Integer> list) throws Exception{
        log.info("list: {}", list);
        return list.stream().mapToInt(a -> a).sum();
    }
}
