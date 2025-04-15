package org.example.sec02;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec10MonoDefer {

    /**
     * ¿Qué es Mono.defer?
     * Mono.defer es un operador que permite crear un Mono de manera perezosa. Es decir, en lugar de crear el Mono inmediatamente, Mono.defer retrasa su creación hasta que un suscriptor se suscribe a él. Esto se logra pasando una función (un Supplier) que devuelve un Mono.
     *
     * ¿Cómo funciona?
     * Cuando usas Mono.defer, la función que proporcionas (el Supplier) no se ejecuta hasta que alguien se suscribe al Mono. Esto significa que:
     *
     * La lógica dentro del Supplier se ejecuta solo cuando es necesario.
     *
     * Puedes acceder a estados o contextos que no estaban disponibles en el momento de la definición del Mono.
     * ¿Cuándo usar Mono.defer?
     * Acceso a estados dinámicos:
     *
     * Si necesitas acceder a un estado o contexto que no está disponible en el momento de la definición del Mono, Mono.defer es la solución. Por ejemplo, si el valor depende de una variable que cambia con el tiempo.
     *
     * Evitar efectos secundarios prematuras:
     *
     * Si la creación del Mono tiene efectos secundarios (por ejemplo, una llamada a una base de datos o un servicio web), Mono.defer asegura que esos efectos secundarios no ocurran hasta que alguien se suscribe.
     *
     * Reutilización de lógica:
     *
     * Si tienes una lógica compleja para crear un Mono y quieres reutilizarla en diferentes contextos, Mono.defer te permite encapsular esa lógica en una función.
     */

    private static final Logger log = LoggerFactory.getLogger(Lec05MonoFromSupplier.class);
    public static void main(String[] args) {

        Mono.defer(Lec10MonoDefer::createPublisher);
                //.subscribe(Util.subscriber("A"));
    }

    public static Mono<Integer> createPublisher() {
        log.info("Creating publisher");
        var list = List.of(1,2,3,4,5);
        Util.sleepSeconds(3);
        return Mono.fromSupplier(() -> sum(list));
    }

    public static int sum(List<Integer> list) {
        log.info("list: {}", list);
        Util.sleepSeconds(3);
        return list.stream().mapToInt(a -> a).sum();
    }

}
