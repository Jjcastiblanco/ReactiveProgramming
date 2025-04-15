package org.example.sec02;

import org.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;



public class Lec07MonoFromRunnable {


    /*
        Casos de Uso
        Runnable:

        Ejecutar tareas de fondo que no devuelven un valor (por ejemplo, notificaciones, logs, limpieza de recursos).

        En el código: notifyBussines(productId) es una tarea que solo registra un mensaje en los logs.

        Supplier:

        Generar valores de manera perezosa (por ejemplo, nombres aleatorios, cálculos costosos).

        En el código: Util.faker().commerce().productName() genera un nombre de producto solo cuando se suscribe al Mono.

        Callable:

        Ejecutar tareas que pueden fallar y necesitan manejo de excepciones (por ejemplo, llamadas a APIs, operaciones de base de datos).

        No se usa en el código, pero sería útil si notifyBussines o getProductName pudieran lanzar excepciones.
     */

    private final static Logger log = LoggerFactory.getLogger(Lec07MonoFromRunnable.class);
    public static void main(String[] args) {
        getProductName(2).subscribe(Util.subscriber("A"));

    }

    private static Mono<String> getProductName(int productId) {
        if (productId == 1) {
            return Mono.fromSupplier(() -> Util.faker().commerce().productName());
        }
        return Mono.fromRunnable(() -> notifyBussines(productId));
    }

    private static void notifyBussines(int productId) {
        log.info("Notifying bussines on unavailable product {}", productId);
    }
}
