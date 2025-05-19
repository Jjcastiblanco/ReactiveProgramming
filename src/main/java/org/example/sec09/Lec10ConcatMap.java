package org.example.sec09;

import org.example.applications.OrderService;
import org.example.applications.User;
import org.example.applications.UserService;
import org.example.common.Util;

public class Lec10ConcatMap {


    /*
        concatMap: Transformación con orden secuencial
        Definición:

        Transforma cada elemento en un nuevo flujo, pero espera a que cada flujo interno termine antes de procesar el siguiente.

        Preserva el orden original de los elementos.

        Comportamiento:

        Los flujos internos se ejecutan uno tras otro, en secuencia.

        Garantiza el orden, pero puede ser más lento (no hay concurrencia).
     */

    public static void main(String[] args) {

        /*
         El operador Flat map no tiene un orden especifico
         por eso si queremos controlar el orden usamos o liminamos los hilos
         */
        UserService.getUsers()
                .map(User::id)
                .concatMap(OrderService::getUserOrders,1)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(30);

    }
}
