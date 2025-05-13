package org.example.sec05;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.function.UnaryOperator;


/*
    transform
    Reutilización de lógica: Cuando tienes una secuencia de operadores que se repite en diferentes partes de tu aplicación, puedes encapsularla en una función y aplicarla con transform, promoviendo la reutilización y reduciendo la duplicación de código.​

    Mejora de la legibilidad: Al encapsular operaciones complejas en funciones descriptivas, el flujo principal se vuelve más legible y fácil de entender.​

    Composición modular: Permite construir flujos complejos a partir de componentes más simples y reutilizables.

 */
public class Lec10Transform {

    record Customer(int id, String name){}
    record Purchase(String product, int price, int quantity){}


    public static void main(String[] args) {

        getCustumers()
                .transform(addDebugger())
                .subscribe(Util.subscriber());



    }

    private static Flux<Customer> getCustumers(){
        return Flux.range(1,3)
                .map(i-> new Customer(i, Util.faker().name().firstName()));
    }

    private static Flux<Purchase>getPurchases(){
        return Flux.range(1,3)
                .map(i-> new Purchase(Util.faker().commerce().productName(), i, i*10));
    }

    private static <T>UnaryOperator<Flux<T>> addDebugger(){
        return flux -> flux
                .doOnNext(i -> System.out.println("emitting value: " + i))
                .doOnError(e -> System.out.println("error: " + e))
                .doOnComplete(() -> System.out.println("done"));
    }
}
