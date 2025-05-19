package org.example.sec09;

import org.example.applications.OrderService;
import org.example.applications.UserService;
import org.example.common.Util;

public class Lec09FluxFlatMap {

    public static void main(String[] args) {

        /*
         El operador Flat map no tiene un orden especifico
         por eso si queremos controlar el orden usamos o liminamos los hilos

         1. flatMap: Transformación con concurrencia
        Definición:

        Transforma cada elemento de un flujo en un nuevo flujo (Publisher) y fusiona (merge) todos esos flujos resultantes en uno solo.

        Los flujos internos se procesan en paralelo (sin garantizar orden).

        Comportamiento:

        Si el flujo original emite elementos rápidamente, los flujos internos se solaparán.

        No garantiza el orden de los elementos finales (depende del tiempo de cada flujo interno).
         */
        UserService.getUsers().map(user -> user.id()).flatMap(userId -> OrderService.getUserOrders(userId), 1).subscribe(Util.subscriber());

        Util.sleepSeconds(30);

    }
}
